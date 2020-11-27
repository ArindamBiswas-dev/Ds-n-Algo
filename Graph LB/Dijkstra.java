import java.util.*;

class Dijkstra{

	public static int selectMinimumVertex(int[] value, boolean[] processed){
		int minValue = Integer.MAX_VALUE;
		int min = -1;

		for(int i=0; i<value.length; i++){
			if(value[i] < minValue && processed[i] == false){
				min = i;
				minValue = value[i];
			}
		}
		return min;
	}

	public static void dijkstra(int[][] g){
		int[] parent = new int[g.length];
		int[] value = new int[g.length];
		boolean[] processed = new boolean[g.length];

		
		Arrays.fill(value, Integer.MAX_VALUE);
		Arrays.fill(processed, false);

		int totalVertex = g.length;

		value[0] = 0;
		parent[0] = -1;

		for(int i=0; i<totalVertex-1; ++i){

			// select the minimum vertex
			int U = selectMinimumVertex(value, processed);

			// mark processed as true
			processed[U] = true;

			// relax all of its adj. vertex
			for(int j=0; j<totalVertex; ++j){
				if(g[U][j]!=0 && processed[j]==false && value[U]!=Integer.MAX_VALUE && (value[U]+g[U][j] < value[j])){
					value[j] = value[U] + g[U][j];
					parent[j] = U;
				}
			}
		}

		// print the graph
		for(int k=0; k<totalVertex; k++){
			System.out.println("vertex :"+k+" parent :"+parent[k]+" value :"+value[k]);
		}
	}

	public static void main(String[] args) {
		int[][] graph = {
							{0, 1, 4, 0, 0, 0},
							{1, 0, 4, 2, 7, 0},
							{4, 4, 0, 3, 5, 0},
							{0, 2, 3, 0, 4, 6},
							{0, 7, 5, 4, 0, 7},
							{0, 0, 0, 6, 7, 0}
						};
		dijkstra(graph);
	}
}