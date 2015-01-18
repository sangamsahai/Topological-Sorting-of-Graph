
public class Vertex {
	
	String name;
	Neighbour adjList;
	int inDegree=0;// will hold the inDegree for all the nodes
    boolean putInQueue=false;
	
	public Vertex(String name,Neighbour neighbours)
	{
		this.name=name;
		this.adjList=neighbours;
	}

	
	
}
