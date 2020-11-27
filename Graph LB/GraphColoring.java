import java.util.*;

// detect cycle in directed graph using Graph Coloring method

class GraphColoring{

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	int white = 0, grey = 1, black = 2;

	public static void main(String[] args) {
		
		GraphColoring g1 = new GraphColoring();
		int V = 4;
		for(int i=0; i<4; i++){
			graph.add(new ArrayList<Integer>());
		}

		g1.addEdge(1, 0);
		g1.addEdge(0, 2); 
		g1.addEdge(0, 3);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(3, 0);

		System.out.println(graph);
		System.out.print(g1.isCycle());

	}

	void addEdge(int v,int w) 
	{ 
		graph.get(v).add(w);
	
	}

	boolean isCycle(){
		
		int[] color = new int[4];
		Arrays.fill(color, white);

		for(int i=0; i<4; i++){
			if(color[i] == white && isCycleUtil(color, i))
				return true;
		}
		return false;
	}

	boolean isCycleUtil(int[] color, int curr){

		color[curr] = grey;

		ArrayList<Integer> adjNodes = graph.get(curr);
		for(Integer i : adjNodes){
			if(color[i] == grey){
				return true;
			}
			if(color[i] == white && isCycleUtil(color, i) == true)
				return true;
		}
		color[curr] = black;
		return false;
	}

}