import java.util.*;

class Edge{
	int src;
	int dest;
	int weight;
}

class Graph{
	int V;
	int E;
	Edge[] edge;

	Graph(int v, int e){
		V = v;
		E = e;
		edge = new Edge[e];

		for(int i=0; i<e; i++){
			edge[i] = new Edge();
		}
	}
}

class LongestPathDAG{
	public static void main(String[] args) {
		Graph g = new Graph(4, 4);

		g.edge[0].src = 0;
		g.edge[0].dest = 1;
		g.edge[0].weight = -10;

		g.edge[1].src = 0;
		g.edge[1].dest = 3;
		g.edge[1].weight = 1;

		g.edge[2].src = 1;
		g.edge[2].dest = 2;
		g.edge[2].weight = 1;

		g.edge[3].src = 2;
		g.edge[3].dest = 3;
		g.edge[3].weight = 1;

		LongestPathDAG lpd = new LongestPathDAG();
		lpd.findLongestPaths(Graph, 4);
	}

	void findLongestPaths(Graph g, int V){
		Stack<Integer> st = new Stack<Integer>();
		boolean[] visited = new boolean[V];

		for(int i=0; i<V; i++){
			if(visited[i] == false)
				topoSort(g, V, i, st, visited);
		}
	}

	void topoSort(Graph g, int v, int curr, Stack<Integer> st, boolean[] visited){
		visited[curr] = true;
		for()
	}
}