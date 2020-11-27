import java.util.*;

class creatingGraph{

	// function to add edges
	static void addEdge(ArrayList<ArrayList<Integer>> g,int u,int v){
		g.get(u).add(v);
		g.get(v).add(u);
	}

	// function to print the graph
	static void printGraph(ArrayList<ArrayList<Integer>> g){
		for(int i=0;i<g.size();i++){
			System.out.print(i+ "-> ");
			for(int j=0;j<g.get(i).size();j++){
				System.out.print(g.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}


	public static void main(String[] args) {
	
		// creating a graph of 5 vertices
		int V = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(5);
		for(int i=0;i<V;i++){
			graph.add(new ArrayList<Integer>());
		}
		// adding the edges
		addEdge(graph,0,1);
		addEdge(graph,0,2);
		addEdge(graph,1,2);
		addEdge(graph,2,3);
		addEdge(graph,4,1);
		printGraph(graph);
	}
}