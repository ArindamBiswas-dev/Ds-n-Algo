// import java.util.ArrayList; 
// import java.util.LinkedList; 
// import java.util.List;
import java.util.*;

class DijkstraAlgo{
	// List<List<Integer>> adj;

	// DijkstraAlgo(int v){

	// 	adj = new ArrayList<>(v);
	// 	for(int i=0;i<v;i++){
	// 		adj.add(new LinkedList<>());
	// 	}
	// }

	// void addEdge(int source,int destination,int weight){
	// 	adj.get(source).add(destination);
	// 	adj.get(destination).add(source);
	// }

	int findMin(int[] value,boolean[] processed){

		int vertex = 0;
		int minimum = Integer.MAX_VALUE;
		for(int i=0;i<6;i++){
			if(processed[i] == false && value[i] < minimum){
				vertex = i;
				minimum = value[i];
			}
		}
		return vertex;
	}

	void Dijkstra(int[][] graph,int v){
		int[] parent = new int[v];
		boolean[] processed = new boolean[v];
		int[] value = new int[v];

		Arrays.fill(parent, -1);
		Arrays.fill(value, Integer.MAX_VALUE);

		value[0] = 0;
		for(int i=0;i<v-1;i++){
			
			int u = findMin(value,processed);	// find min cost node, first min cost node is source node scence it's cost is 0
			processed[u] = true;

			for(int j=0;j<v;j++){

				if(graph[u][j] != 0 && processed[j] == false && (value[u]+graph[u][j] < value[j])){
					value[j] = value[u]+graph[u][j];
					parent[j] = u;
				}
				
			}
		}

		for(int i=1;i<v;i++){
			System.out.print("Vertex : "+i+" Parent : "+ parent[i]+" Cost : "+value[i]);
			System.out.println();    
		}

	}

	public static void main(String[] args) {
		DijkstraAlgo g = new DijkstraAlgo();
		int v = 6;
		// g.addEdge(0,1);
		// g.addEdge(0,2);
		// g.addEdge(1,2);
		// g.addEdge(1,3);
		// g.addEdge(1,4);
		// g.addEdge(2,3);
		// g.addEdge(2,4);
		// g.addEdge(3,4);
		// g.addEdge(3,5);
		// g.addEdge(4,5);

		int[][] graph = {
							{0, 1, 4, 0, 0, 0},
							{1, 0, 4, 2, 7, 0},
							{4, 4, 0, 3, 5, 0},
							{0, 2, 3, 0, 4, 6},
							{0, 7, 5, 4, 0, 7},
							{0, 0, 0, 6, 7, 0} 
						};
						
		g.Dijkstra(graph,v);

	}
}