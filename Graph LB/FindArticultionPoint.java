import java.util.*;

class FindArticultionPoint{
	public static void main(String[] args) {
		int v = 6;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(v);

		for(int i=0;i<v;i++){
			graph.add(new ArrayList<Integer>());
		}

		FindArticultionPoint ap = new FindArticultionPoint();

		ap.addEdge(graph, 0, 1);
		ap.addEdge(graph, 0, 2);
		ap.addEdge(graph, 1, 2);
		ap.addEdge(graph, 0, 3);
		ap.addEdge(graph, 3, 4);
		ap.addEdge(graph, 3, 5);

		ap.findAP(graph, v);
	}

	void addEdge(ArrayList<ArrayList<Integer>> g, int src, int dest){
		g.get(src).add(dest);
		g.get(dest).add(src);
	}

	void findAP(ArrayList<ArrayList<Integer>> g, int v){
		int[] low = new int[v];
		int[] desc = new int[v];
		int[] parent = new int[v];
		boolean[] ap = new boolean[v];
		int time = 0;

		Arrays.fill(low, -1);
		Arrays.fill(desc, -1);
		Arrays.fill(parent, -1);

		for(int i=0; i<v; i++){
			if(desc[i] == -1){
				dfs(g, i, desc, low, parent, ap, time);
			}
		}

		for(int i=0; i<v; i++){
			if(ap[i] == true)
				System.out.print(i+" ");
		}
	}

	void dfs(ArrayList<ArrayList<Integer>> g, int curr, int[] desc, int[] low, int[] parent, boolean[] ap, int time){
		desc[curr] = time;
		low[curr] = time;
		time += 1;
		int children = 0;

		for(Integer i : g.get(curr)){
			if(desc[i] == -1){
				children += 1;
				parent[i] = curr;
				dfs(g, i, desc, low, parent, ap, time);
				low[curr] = Math.min(low[curr], low[i]);

				if(parent[curr] == -1 && children > 1){	// finding articulation point
					ap[curr] = true;
				}
				if(parent[curr] != -1 && desc[curr] <= low[i]){
					ap[curr] = true;
				}
			} else if(i != parent[curr]){
				low[curr] = Math.min(low[curr], desc[i]);
			}
		}
	}
}