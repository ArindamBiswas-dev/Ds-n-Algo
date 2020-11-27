import java.util.*;

class TarjanSCC{
	public static void main(String[] args) {
		int v = 8;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(v);

		for(int i=0;i<v;i++){
			graph.add(new ArrayList<Integer>());
		}

		TarjanSCC tj = new TarjanSCC();

		tj.addEdge(graph, 0, 1);
		tj.addEdge(graph, 1, 2);
		tj.addEdge(graph, 1, 3);
		tj.addEdge(graph, 3, 4);
		tj.addEdge(graph, 4, 0);
		tj.addEdge(graph, 4, 5);
		tj.addEdge(graph, 4, 6);
		tj.addEdge(graph, 5, 2);
		tj.addEdge(graph, 5, 6);
		tj.addEdge(graph, 6, 5);

		tj.findScc(graph, v);
	}

	void addEdge(ArrayList<ArrayList<Integer>> g, int src, int dest){
		g.get(src).add(dest);
	}

	void findScc(ArrayList<ArrayList<Integer>> g, int v){
		int[] disc = new int[v];
		int[] low = new int[v];
		boolean[] inStack = new boolean[v];
		Stack<Integer> st = new Stack<>();
		int time = 0;

		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);

		for(int i=0; i<v; i++){
			if(disc[i] == -1){
				dfs(g, v, i, disc, low, inStack, st, time);
			}
		}
	}

	void dfs(ArrayList<ArrayList<Integer>> g, int v, int curr, int[] disc, int[] low, boolean[] inStack, Stack<Integer> st, int time){
		low[curr] = time;
		disc[curr] = time;
		time += 1;
		inStack[curr] = true;
		st.push(curr);

		for(Integer i : g.get(curr)){
			if(disc[i] == -1){
				dfs(g, v, i, disc, low, inStack, st, time);
				low[curr] = Math.min(low[i], low[curr]);
			} else if(inStack[i]){
				low[curr] = Math.min(low[curr], disc[i]);
			}
		}

		if(low[curr] == disc[curr]){
			System.out.print("SCC is: ");
			while(st.peek() != curr){
				int ele = st.pop();
				System.out.print(ele+" ");
				inStack[ele] = false;
			}
			int ele = st.pop();
			System.out.println(ele);
			inStack[ele] = false;
		}
	}
}