import java.util.*;

class Kosaraju{
	public static void main(String[] args) {
		int v = 8;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(v);

		for(int i=0;i<v;i++){
			graph.add(new ArrayList<Integer>());
		}

		Kosaraju kj = new Kosaraju();

		kj.addEdge(graph, 0, 1);
		kj.addEdge(graph, 1, 2);
		kj.addEdge(graph, 2, 0);
		kj.addEdge(graph, 2, 3);
		kj.addEdge(graph, 3, 4);
		kj.addEdge(graph, 4, 5);
		kj.addEdge(graph, 4, 7);
		kj.addEdge(graph, 5, 6);
		kj.addEdge(graph, 6, 4);
		kj.addEdge(graph, 6, 7);

		kj.findScc(graph, v);
	}

	void addEdge(ArrayList<ArrayList<Integer>> g, int src, int dest){
		g.get(src).add(dest);
	}

	void findScc(ArrayList<ArrayList<Integer>> g, int v){
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[v];
		int count = 0;

		for(int i=0; i<v; i++){
			if(visited[i] == false){
				dfs1(g, i, visited ,st);
			}
		}
		
		ArrayList<ArrayList<Integer>> reverseGraph = reverseEdge(g, v);
		
		Arrays.fill(visited, false);

		for(int i=0; i<v; i++){
			if(visited[i] == false){
				dfs2(reverseGraph, i, visited);
			} else {
				++count;
			}
		}
		System.out.print(count);
	}

	void dfs1(ArrayList<ArrayList<Integer>> g, int curr, boolean[] visited, Stack<Integer> st){
		visited[curr] = true;
		ArrayList<Integer> adjList = g.get(curr);

		for(Integer i : adjList){
			if(visited[i] == false){
				dfs1(g, i, visited, st);
			}
		}
		st.push(curr);
	}

	ArrayList<ArrayList<Integer>> reverseEdge(ArrayList<ArrayList<Integer>> g, int v){
		ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<ArrayList<Integer>>(v);
		for(int i=0; i<v; i++){
			reverseGraph.add(new ArrayList<Integer>());
		}

		for(int i=0; i<v; i++){
			ArrayList<Integer> adjList = g.get(i);
			for(Integer k : adjList){
				reverseGraph.get(k).add(i);
			}
		}
		return reverseGraph;
	}

	void dfs2(ArrayList<ArrayList<Integer>> g, int curr, boolean[] visited){
		visited[curr] = true;
		ArrayList<Integer> adjList = g.get(curr);

		for(Integer i : adjList){
			if(visited[i] == false){
				dfs2(g, i, visited);
			}
		}
	}
}