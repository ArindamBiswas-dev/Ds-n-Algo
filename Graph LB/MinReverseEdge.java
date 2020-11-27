import java.util.*;		// Concepts of Dijkstra....

class MinReverseEdge{
	public static void main(String[] args) {
		ArrayList<ArrayList<int[]>> g = new ArrayList<ArrayList<int[]>>();
		int V = 7;
		int[][] egdeList = 	{
								{0, 1}, {2, 1}, {2, 3},
								{5, 1}, 
	                     		{4, 5}, {6, 4}, {6, 3}
                     		};
        int E = 7;

        MinReverseEdge mre = new MinReverseEdge();
        System.out.print(mre.findReverseEdge(g, V, E, egdeList));
	}

	int findReverseEdge(ArrayList<ArrayList<int[]>> g, int V, int E, int[][] egdeList){
		for(int i=0; i<V; i++){
			g.add(new ArrayList<int[]>());
		}

		for(int[] edge : egdeList){
			addEdge(g, edge);
		}

		int src = 0;
		int dest = 6;

		int x = findReverseEdgeUtil(g, V, src, dest);
		return x;
	}

	void addEdge(ArrayList<ArrayList<int[]>> g, int[] edge){
		g.get(edge[0]).add(new int[]{edge[1], 0});

		g.get(edge[1]).add(new int[]{edge[0], 1});
	}

	int findReverseEdgeUtil(ArrayList<ArrayList<int[]>> g, int V, int src, int dest){
		int[] value = new int[V];
		int[] parent = new int[V];
		boolean[] processed = new boolean[V];

		Arrays.fill(value, Integer.MAX_VALUE);
		value[src] = 0;
		parent[src] = -1;

		for(int i=0; i<V; i++){
			int u = selectMinVertex(value, processed);

			processed[u] = true;

			for(int[] k : g.get(u)){

				int v = k[0];
				int w = k[1];

				if(processed[v] == false && value[u] != Integer.MAX_VALUE && value[u]+w < value[v]){
					value[v] = value[u]+w;
					parent[v] = u;
				}
			}
		}
		return value[dest];
	}

	int selectMinVertex(int[] value, boolean[] processed){
		int minValue = Integer.MAX_VALUE;
		int min = 0;

		for(int i=0; i<value.length; i++){
			if(processed[i] == false && value[i] < minValue){
				minValue = value[i];
				min = i;
			}
		}
		return min;
	}
}