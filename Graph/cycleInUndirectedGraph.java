import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List;

class cycleInUndirectedGraph{

	// int v;
	List<List<Integer>> adj;

	cycleInUndirectedGraph(int v){
		// this.v = v;
		adj = new ArrayList<>(v);
		for(int i=0;i<v;i++){
			adj.add(new LinkedList<>());
		}
	}

	void addEdge(int source,int destination){
		adj.get(source).add(destination);
	}

	boolean isCyclicUtil(int index,boolean[] visited,boolean[] recStack){
		if(visited[index] == false){
			visited[index] = true;
			recStack[index] = true;
			List<Integer> children = adj.get(index);
			for(Integer c : children){
				if(!visited[c] && isCyclicUtil(c,visited,recStack)) return true;
				if(recStack[c] == true) return true;
			}
		}
		recStack[index] = false;
		return false;
	}

	boolean isCyclic(int v){
		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];
		for(int i=0;i<v;i++){
			if(isCyclicUtil(i,visited,recStack)){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		cycleInUndirectedGraph g = new cycleInUndirectedGraph(3);
	//	g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(2,1);
		g.addEdge(0,1);
		System.out.print(g.isCyclic(3));
	}
}




// A Java Program to detect cycle in a graph 
// import java.util.ArrayList; 
// import java.util.LinkedList; 
// import java.util.List;

// class cycleInUndirectedGraph{ 

// 	private final int V; 
// 	private final List<List<Integer> > adj; 

// 	public cycleInUndirectedGraph(int V) 
// 	{ 
// 		this.V = V; 
// 		adj = new ArrayList<>(V); 

// 		for (int i = 0; i < V; i++) 
// 			adj.add(new LinkedList<>()); 
// 	} 

// 	// This function is a variation of DFSUytil() in 
// 	// https:// www.geeksforgeeks.org/archives/18212 
// 	private boolean isCyclicUtil(int i, boolean[] visited, 
// 								boolean[] recStack) 
// 	{ 

// 		// Mark the current node as visited and 
// 		// part of recursion stack 
// 		if (recStack[i]) 
// 			return true; 

// 		if (visited[i]) 
// 			return false; 

// 		visited[i] = true; 

// 		recStack[i] = true; 
// 		List<Integer> children = adj.get(i); 

// 		for (Integer c : children) 
// 			if (isCyclicUtil(c, visited, recStack)) 
// 				return true; 

// 		recStack[i] = false; 

// 		return false; 
// 	} 

// 	private void addEdge(int source, int dest) 
// 	{ 
// 		adj.get(source).add(dest); 
// 	} 

// 	// Returns true if the graph contains a 
// 	// cycle, else false. 
// 	// This function is a variation of DFS() in 
// 	// https:// www.geeksforgeeks.org/archives/18212 
// 	private boolean isCyclic() 
// 	{ 

// 		// Mark all the vertices as not visited and 
// 		// not part of recursion stack 
// 		boolean[] visited = new boolean[V]; 
// 		boolean[] recStack = new boolean[V]; 

// 		// Call the recursive helper function to 
// 		// detect cycle in different DFS trees 
// 		for (int i = 0; i < V; i++) 
// 			if (isCyclicUtil(i, visited, recStack)) 
// 				return true; 

// 		return false; 
// 	} 

// 	// Driver code 
// 	public static void main(String[] args) 
// 	{ 
// 		cycleInUndirectedGraph graph = new cycleInUndirectedGraph(2); 
// 		graph.addEdge(0, 1); 
// 		graph.addEdge(1, 0);
// 		// graph.addEdge(2, 3); 
// 		// graph.addEdge(3, 4); 
// 		// graph.addEdge(2, 3); 
// 		// graph.addEdge(3, 3);

// 		if (graph.isCyclic()) 
// 			System.out.println("Graph contains cycle"); 
// 		else
// 			System.out.println("Graph doesn't "
// 							+ "contain cycle"); 
// 	} 
// } 
