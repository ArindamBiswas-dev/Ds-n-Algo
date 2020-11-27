import java.util.*;

class FindBridges{
	public static void main(String[] args) {
		int v = 5;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(v);

		for(int i=0;i<v;i++){
			graph.add(new ArrayList<Integer>());
		}

		FindBridges fb = new FindBridges();

		fb.addEdge(graph, 0, 1);
		fb.addEdge(graph, 0, 2);
		fb.addEdge(graph, 1, 2);
		fb.addEdge(graph, 0, 3);
		fb.addEdge(graph, 3, 4);

		fb.findBridges(graph, v);
	}

	void addEdge(ArrayList<ArrayList<Integer>> g, int src, int dest){
		g.get(src).add(dest);
		g.get(dest).add(src);
	}

	void findBridges(ArrayList<ArrayList<Integer>> g, int v){
		int[] disc = new int[v];
		int[] low = new int[v];
		int[] parent = new int[v];
		ArrayList<int[]> bridges = new ArrayList<int[]>();
		int time = 0;

		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);
		Arrays.fill(parent, -1);

		for(int i=0; i<v; i++){
			if(disc[i] == -1){
				dfs(g, i, disc, low, parent, time, bridges);
			}
		}

		for(int i=0; i<bridges.size(); i++){
			System.out.println(bridges.get(i)[0]+" "+bridges.get(i)[1]);
		}
	}

	void dfs(ArrayList<ArrayList<Integer>> g, int curr, int[] disc, int[] low, int[] parent, int time, ArrayList<int[]> bridges){
		low[curr] = time;
		disc[curr] = time;
		time += 1;

		for(Integer i : g.get(curr)){
			if(disc[i] == -1){
				parent[i] = curr;
				dfs(g, i, disc, low, parent, time, bridges);
				low[curr] = Math.min(low[i], low[curr]);

				if(disc[curr] < low[i]){ 				// finding the bridges
					bridges.add(new int[]{curr, i});
				}
			} else if(i != parent[curr]){
				low[curr] = Math.min(low[curr], disc[i]);
			}
		}
	}
}