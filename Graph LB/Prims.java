import java.util.*;

class Prims{
	public static void main(String[] args) {
		int[][] graph = {

					{0, 4, 6, 0, 0, 0},
					{4, 0, 6, 3, 4, 0},
					{6, 6, 0, 1, 8, 0},
					{0, 3, 1, 0, 2, 3},
					{0, 4, 8, 2, 0, 7},
					{0, 0, 0, 3, 7, 0}
				};
		int V = 6;

		prims(graph, V);
	}
	static void prims(int[][] g, int V){
		int[] parent = new int[V];
		int[] value = new int[V];
		boolean[] mst = new boolean[V];

		Arrays.fill(value, Integer.MAX_VALUE);

		int startNode = 0;
		parent[startNode] = -1;
		value[startNode] = 0;

		for(int i=0; i<V-1; i++){

			// int select min vertex
			int U = selectMinVertex(value, mst);
			mst[U] = true;

			// relax all of its adj. vertex
			for(int j=0; j<V; j++){
				if(g[U][j] != 0 && mst[j] == false && g[U][j] < value[j]){
					value[j] = g[U][j];
					parent[j] = U;
				}
			}
		}

		// print mst
		for(int i=0; i<V; i++){
			System.out.println("Node "+i+" Parent "+parent[i]+" Weight "+value[i]);
		}
	}
	static int selectMinVertex(int[] value, boolean[] mst){
		int minimum = Integer.MAX_VALUE;
		int min = 0;

		for(int i=0; i<value.length; i++){
			if(mst[i] == false && value[i] < minimum){
				min = i;
				minimum = value[i];
			}
		}
		return min;
	}
}