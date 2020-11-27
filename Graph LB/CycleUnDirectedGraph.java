// A Java Program to detect cycle in an undirected graph 
import java.io.*; 
import java.util.*; 
// This class represents a 
// directed graph using adjacency list 
// representation 
class CycleUnDirectedGraph
{ 
	static int count = 0;
	// No. of vertices 
	private int V; 
	static int disconnected = 0;
	
	// Adjacency List Represntation 
	private LinkedList<Integer> adj[];

	// Constructor 
	CycleUnDirectedGraph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for(int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	// Function to add an edge 
	// into the graph 
	void addEdge(int v,int w) 
	{ 
		adj[v].add(w); 
		adj[w].add(v); 
	} 

	// A recursive function that 
	// uses visited[] and parent to detect 
	// cycle in subgraph reachable 
	// from vertex v. 
	Boolean isCyclicUtil(int v, 
				Boolean visited[], int parent) 
	{ 
		// Mark the current node as visited 
		visited[v] = true; 
		Integer i; 

		// Recur for all the vertices 
		// adjacent to this vertex 
		Iterator<Integer> it = 
				adj[v].iterator(); 
		while (it.hasNext()) 
		{ 
			i = it.next(); 

			// If an adjacent is not 
			// visited, then recur for that 
			// adjacent 
			if (!visited[i]) 
			{ 
				disconnected++;
				if (isCyclicUtil(i, visited, v))
					return true;
			} 

			// If an adjacent is visited 
			// and not parent of current 
			// vertex, then there is a cycle. 
			else if (i != parent) 
				{++count; return true; }
		} 
		return false; 
	} 

	// Returns true if the graph 
	// contains a cycle, else false. 
	Boolean isCyclic() 
	{ 
		
		// Mark all the vertices as 
		// not visited and not part of 
		// recursion stack 
		Boolean visited[] = new Boolean[V]; 
		for (int i = 0; i < V; i++) 
			visited[i] = false;

		

		// Call the recursive helper 
		// function to detect cycle in 
		// different DFS trees 
		for (int u = 0; u < V; u++) 
		{ 
		
			// Don't recur for u if already visited 
			if (!visited[u]) 
				if (isCyclicUtil(u, visited, -1)) System.out.print("Hello");
										
		} 
		
				// for(int i=0; i<V; i++){
				// 	if(visited[i] == true){
				// 		disconnected++;
				// 	}
				// }
				
		return (count > 0) ? true : false; 
	} 


	// Driver method to test above methods 
	public static void main(String args[]) 
	{ 
		
		// Create a graph given 
		// in the above diagram 
		CycleUnDirectedGraph g1 = new CycleUnDirectedGraph(6); 
		g1.addEdge(1, 0);
		g1.addEdge(0, 2); 
		g1.addEdge(0, 3);
		g1.addEdge(1, 2);
		// g1.addEdge(1, 3);
		
		if (g1.isCyclic()) 
			System.out.println("Graph contains cycle"); 
		else
			System.out.println("Graph doesn't contains cycle");
		System.out.println(+count+" Total Cycle");
		System.out.print(disconnected+" disconnected");
	} 
}
