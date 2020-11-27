import java.util.*;

class kLength{

	static void addEdge(ArrayList<ArrayList<int[]>> g, int u, int v, int wt){
		g.get(u).add(new int[] {v, wt});
		g.get(v).add(new int[] {u, wt});
	}

	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<int[]>> graph = new ArrayList<ArrayList<int[]>>(5);
		boolean[] visited = new boolean[V];
		int src = 0;

		for(int i=0;i<V;i++){
			graph.add(new ArrayList<int[]>());
		}

		addEdge(graph, 0, 1, 3);
		addEdge(graph, 0, 2, 5);
		addEdge(graph, 1, 3, 4);
		addEdge(graph, 2, 3, 2);
		addEdge(graph, 2, 4, 1);

		int K = 11;
		kLength kl = new kLength();
		System.out.print(kl.findLength(graph, K, visited, src));
	}
	boolean findLength(ArrayList<ArrayList<int[]>> g, int K, boolean[] visited, int curr){
		if(K <= 0) return true;

		visited[curr] = true;

		for(int[] i : g.get(curr)){
			if(visited[i[0]] == false){
				if(findLength(g, K-i[1], visited, i[0])) return true;
			}
		}

		visited[curr] = false;
		return false;
	}
}