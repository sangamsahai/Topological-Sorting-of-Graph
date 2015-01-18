This is an implementation  of Topological Sorting of a directed Graph in Java.

This application sorts the graph topologically.
Please note that for this ,the graph should be a DAG(Directed Acyclic Graph).

Topological sorting is used in a lot of practical applications like job scheduling.

We use the following steps in the algorithm  -

1) Traverse through the complete graph and find the in degree of all the vertices.
2) Put the vertex with in degree zero, in the queue.
3) Traverse trough the neighbors of the vertex in queue and reduce their in degree by 1.
4) Print the vertex in the queue and then remove it from the Queue.
5) Repeat the steps 1-4 until the queue is empty.

Time complexity of this Algorithm is O(e) where e is the number of edged in the graph.

The data structure used for the graph is adjacency matrix.
The graph is built from a notepad file which contains the details of the graph.
The first line is 'directed' or 'undirected' which tells if the graph is directed or undirected.
Second detail is the number of vertices.
Then the vertices are written in separate lines.
Finally the edges  are written (considering the direction also) in the graph.
A sample graph.txt has been kept in the repository for your reference.
