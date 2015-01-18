import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

/*This application takes a graph as input and sorts it topologically.
 * Please note that the graph should be a DAG(Directed Acyclic Graph)
 * */
public class TopologicalSorting {

	Graph graph;


	//This function traverses the graph and records the initial in degree of all the vertices .
	public void recordInitialInDegree()
	{
		int noOfVertices=graph.adjLists.length;//holds the total number of vertices in the graph

		if(noOfVertices==0)
		{
			System.out.println("The graph has no vertices");
			System.exit(0);
		}
		for(int i=0;i<noOfVertices;i++)
		{

			Neighbour nbr=graph.adjLists[i].adjList;//first neighbour of i(th) Vertex
			if(nbr==null)
			{
				continue;
			}
			while(nbr!=null)
			{
				int indexOfNbr=nbr.vertexNum;
				graph.adjLists[indexOfNbr].inDegree=graph.adjLists[indexOfNbr].inDegree+1; 
				nbr=nbr.next;
			}//end of while
		}//end of for

	}//end of function recordInitialInDegree

	public void  getTopologicalOrder()
	{ 
		recordInitialInDegree();
		Queue<Vertex> queue = new LinkedList<Vertex>();//This queue will be used to put all the vertices with in degree zero
		int indexOfVertexWithInDegreeZero=-1;//This index will represent the first vertex with in degree zero
		int noOfVertices=graph.adjLists.length;
		for(int i=0;i<noOfVertices;i++)
		{
			int inDegree=graph.adjLists[i].inDegree;
			if (inDegree==0)
			{
				indexOfVertexWithInDegreeZero=i;
				break;

			}
		}//end of for

		graph.adjLists[indexOfVertexWithInDegreeZero].putInQueue=true;
		queue.add(graph.adjLists[indexOfVertexWithInDegreeZero]);//the first vertex with inDegree zero is added to the queue
		while(queue.isEmpty()==false)
		{

			Neighbour nbr=queue.peek().adjList;//get the vertex from the queue but do not  remove it yet

			//in degree of all the neighbours of nbr will be reduced by 1
			while(nbr!=null)
			{

				graph.adjLists[nbr.vertexNum].inDegree=graph.adjLists[nbr.vertexNum].inDegree-1;
				nbr=nbr.next;
			}//end of inner while

			//nbr is printed and then removed from queue
			print(queue.peek());
			queue.remove();

			//next vertex with in degree zero (which has not been put initially in the queue) is found
			indexOfVertexWithInDegreeZero=-1;
			noOfVertices=graph.adjLists.length;
			for(int i=0;i<noOfVertices;i++)
			{
				int inDegree=graph.adjLists[i].inDegree;
				if ((inDegree==0) && (graph.adjLists[i].putInQueue==false))
				{
					indexOfVertexWithInDegreeZero=i;
					break;

				}
			}//end of for

			//this new vertex with in degree zero is put in the queue
			if(indexOfVertexWithInDegreeZero!= -1)
			{
				graph.adjLists[indexOfVertexWithInDegreeZero].putInQueue=true;
				queue.add(graph.adjLists[indexOfVertexWithInDegreeZero]);//the next vertex with inDegree zero goes in queue
			}
		}//end of outer while


	}//end of function getTopologicalOrder

	public void print (Vertex vertex)
	{
		System.out.println(vertex.name);
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//I have used this path. You can use any other path of your choice.
		String path="C:\\Users\\sangam\\Desktop\\graph.txt";
		TopologicalSorting topologicalSorting=new TopologicalSorting();
		topologicalSorting.graph=new Graph(path);
		topologicalSorting.getTopologicalOrder();

	}

}
