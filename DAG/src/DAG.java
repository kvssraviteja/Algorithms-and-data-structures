import java.util.*;

public class DAG
{
	public static void main(String args[])
	{
		int V, edge; 
		Scanner sc = new Scanner(System.in);// a Scanner object to scan the input.
		V = sc.nextInt(); // Scans the number of vertices in the graph
		Graph g = new Graph(V);
		for(int i = 0; i < V; i++)
		{
			for(int j = 0; j < V; j++)
			{
				edge = sc.nextInt(); // scans each element of adjacency matrix.
				if(edge == 1)// if an edge exists, adds to the adjacency matrix.
					g.addEdge(i, j);
			}
		}
		if(g.isDAG())//checks for a DAG.
		{
			System.out.println("The graph is DAG");
			System.out.print("A Topological order of the graph : ");
			g.topOrder();
		}
		else
		{
			System.out.println("The graph has a cycle");
			System.out.print("A cycle in the graph : ");
			g.printCycle();// prints the first cycle encountered in the graph while checking for DAG
		}
		sc.close(); //closing the scanner object.
	}
}