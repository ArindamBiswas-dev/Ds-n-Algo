import java.util.*;

class Sol{
	void bfs(ArrayList<ArrayList<Integer>> g){
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[g.size()+1];
		for(int i=1; i<g.size()+1; i++){
			visited[i] = false;
		}

		int startIndex = 3;
		q.add(startIndex);
		visited[startIndex] = true;

		while (q.peek() != null) {
			int curr = q.poll();
			System.out.print(curr+" ");

			for(int i=0; i<g.get(curr).size(); i++){

				int newIndex = g.get(curr).get(i);

				if(visited[newIndex] == false)
					q.add(newIndex);
					visited[newIndex] = true;
			}
		}
	}

	void dfs(ArrayList<ArrayList<Integer>> g){
		boolean[] visited = new boolean[g.size()+1];
		for(int i=1; i<g.size()+1; i++){
			visited[i] = false;
		}

		int startIndex = 2;
		dfsUtil(g, startIndex, visited);
	}

	void dfsUtil(ArrayList<ArrayList<Integer>> g, int startIndex, boolean[] visited){
		visited[startIndex] = true;
		System.out.print(startIndex+" ");

		for(int i=0; i<g.get(startIndex).size(); i++){
			if(visited[g.get(startIndex).get(i)] == false){
				dfsUtil(g, g.get(startIndex).get(i), visited);
			}
		}
	}
}

class bfsDfs{

	static void addEdge(ArrayList<ArrayList<Integer>> g, int u, int v){
		g.get(u).add(v);
		g.get(v).add(u);
	}

	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(5);

		for(int i=0;i<v;i++){
			graph.add(new ArrayList<Integer>());
		}

		addEdge(graph, 1, 2);
		addEdge(graph, 1, 3);
		addEdge(graph, 1, 4);
		addEdge(graph, 2, 3);
		addEdge(graph, 2, 4);

		Sol sol = new Sol();
		sol.bfs(graph);
		System.out.println();
		sol.dfs(graph);
	}
}