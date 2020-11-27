import java.util.*;
class Sol{

	void dfs(ArrayList<ArrayList<Integer>> g, boolean[] visited, Stack<Integer> st, int curr) {
		visited[curr] = true;
		for(Integer i : g.get(curr)){
			if(visited[i] == false){
				dfs(g, visited, st, i);
			}
		}
		st.push(curr);
	}

	void topoSort(ArrayList<ArrayList<Integer>> g, int v){
		boolean[] visited = new boolean[v];
		Stack<Integer> st = new Stack<>();

		for(int i=0; i<v; i++){
			if(visited[i] == false){
				dfs(g, visited, st, i);
			}
		}

		while (!st.empty()) {
			int x = st.pop();
			System.out.print(x+ " ");
		}
	}
}

class TopologicalSort{

	static void addEdge(ArrayList<ArrayList<Integer>> g, int u, int v){
		g.get(u).add(v);
	}

	public static void main(String[] args) {
		int v = 6;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(5);

		for(int i=0;i<v;i++){
			graph.add(new ArrayList<Integer>());
		}

		addEdge(graph, 0, 2);
		addEdge(graph, 0, 3);
		addEdge(graph, 3, 1);
		addEdge(graph, 4, 1);
		addEdge(graph, 5, 0);
		addEdge(graph, 5, 2);

		Sol sol = new Sol();
		sol.topoSort(graph, v);
	}
}