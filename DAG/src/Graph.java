import java.util.*;

//Class to store a graph in form of an adjacency list and to check whether the graph is DAG or not. 
public class Graph
{
	private int V; // number of vertices in the graph
	private ArrayList<Integer> adjList[]; //adjacency list of graph
	private ArrayList<Integer> cycle = new ArrayList<Integer>();// To keep track of cycle in the graph, if exists. Contains elements not in cycle too.
	int cycleStart; // the start point of cycle in the list "cycle"
	boolean isDag;
	
	//constructor. Creates an ArrayList for each vertex
	@SuppressWarnings("unchecked")
	public Graph(int n)
	{
		this.V= n;
		adjList = new ArrayList[n];
		for(int i= 0; i<n; i++)
			adjList[i] = new ArrayList<Integer>(n);
	}
	
	//adds an edge, from vertex a to vertex b ,to the adjacency matrix
	public void addEdge(int a, int b)
	{
		adjList[a].add(b);
	}
	
	// A helper function to isDAG function. Also keeps track of cycles. Returns false if a cycle is found. The cycle is stored in  ArrayList "cycle"
	private boolean isDAGHelper(int v, boolean visited[], boolean rec[]) 
	{
		if(visited[v] == false)
		{
			visited[v] = true;
			rec[v] = true;
			cycle.add(v);
			for(Iterator<Integer> i = adjList[v].iterator(); i.hasNext();  )
			{
				int temp = i.next();
				if(!visited[temp] && !isDAGHelper(temp,visited, rec))
				{
					return false;
				}
				else if(rec[temp])// when a cycle is detected. Back edge.
				{
					cycleStart = cycle.indexOf(temp);
					return false;
				}
			}
		}
		
		rec[v] = false; 
		return true;
	}
	
	// checks if the graph is DAG or not. Returns true if DAG or else false.
	public boolean isDAG() 
	{
		
		boolean[] visited = new boolean[V]; // true when a vertex is visited. Initially all vertices have false.
		boolean[] rec = new boolean[V];// to check for a back edge, i.e. cycle. Refreshes for every iteration with new vertex.
		for(int i = 0; i < V; i++)
		{
			visited[i] = false;
		    rec[i] = false;
		}
		
		for(int i = 0; i < V; i++)
		{
				cycle.clear(); // clears cycle for checking with next vertex.
				cycleStart = 0;
				if(!isDAGHelper(i, visited, rec)) 
					return false;
		}
		
		isDag = true;
		return true;
	}
	
	// A helper function to topOrder function.
	private void topOrderHelper(int n, boolean visited[],Stack<Integer> stk)
	{
		visited[n] = true;
		for(Iterator<Integer> i = adjList[n].iterator(); i.hasNext();  )
		{
			int temp = i.next();
			if(!visited[temp])
				topOrderHelper(temp, visited, stk);
		}
		stk.push(new Integer(n));
	}
	
	//Finds the topological order of the graph. It is called only when the graph is DAG.
	public void topOrder()
	{
		if(isDag != true)
		{
			System.out.println("Error: No topological order. The graph has a cycle.");
			return;
		}
		
		boolean[] visited = new boolean[V];
		Stack<Integer> stk = new Stack<Integer>(); // to keep track of the topological order.
		for(int i = 0; i < V; i++)
		{
			visited[i] = false;
		}
		
		for(int i =0; i<V; i++)
			if(visited[i] == false)
				topOrderHelper(i, visited, stk);
		
		while(!stk.empty())
		{
			System.out.print(stk.pop()+" ");
		}
	}
	
	//It is called only when the graph has cycles. Prints a cycle in the graph.
	public void printCycle()
	{
		if(isDag == true)
		{
			System.out.println("Error: No cycle. The graph is a DAG.");
			return;
		}
		
		int i = cycleStart;
		while(i < cycle.size())
		{
			System.out.print(cycle.get(i) + " ");
			i++;
		}
		System.out.print(cycle.get(cycleStart) + " ");
	}
}