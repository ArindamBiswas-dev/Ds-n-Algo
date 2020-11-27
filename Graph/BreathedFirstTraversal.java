import java.util.*;

class BFS{
	static void bfs(ArrayList<ArrayList<Integer>> g){

		LinkedList<Integer> queue = new LinkedList<Integer>();

		boolean[] visited = new boolean[g.size()+1];
		for(int i=1;i<g.size()+1;i++){
			visited[i] = false;
		}

		int s = 1;
		queue.add(s);
		visited[s] = true;

		while(queue.size() != 0){
			int vertex = queue.poll();
			System.out.print(vertex+ " ");

			for(int i=0;i < g.get(vertex).size();i++){
				int newVertex = g.get(vertex).get(i);

				if(visited[newVertex] == false){
					queue.add(newVertex);
					visited[newVertex] = true;
				}
			}

		}
	}
}

class DFS{
	static void dfs(ArrayList<ArrayList<Integer>> g){

		boolean[] visited = new boolean[g.size()+1];
		for(int i=1;i<g.size()+1;i++){
			visited[i] = false;
		}

		dfsUtil(g,1,visited);
	}

	static void dfsUtil(ArrayList<ArrayList<Integer>> g,int s,boolean[] visited){
		visited[s] = true;
		System.out.print(s+" ");
		for(int i=0;i<g.get(s).size();i++){
			if(visited[g.get(s).get(i)] == false){
				dfsUtil(g,g.get(s).get(i),visited);
			}
		}
	}
}

class BreathedFirstTraversal{

	// function to add edges
	static void addEdge(ArrayList<ArrayList<Integer>> g,int u,int v){
		g.get(u).add(v);
		g.get(v).add(u);
	}

	public static void main(String[] args) {

		// creating a graph of 5 vertices
		int V = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(5);
		for(int i=0;i<V;i++){
			graph.add(new ArrayList<Integer>());
		}

		// adding the edges
		addEdge(graph,1,2);
		addEdge(graph,1,4);
		addEdge(graph,2,3);
		addEdge(graph,3,4);
		addEdge(graph,4,1);
		addEdge(graph,3,4);
	//	BFS b = new BFS();
		System.out.print("BFS -> ");
		BFS.bfs(graph);
		System.out.println();
		System.out.print("DFS -> ");
		DFS.dfs(graph);
	}
}