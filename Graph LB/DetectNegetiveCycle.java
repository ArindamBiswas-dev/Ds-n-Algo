import java.util.*;			// instance of BelmanFord algo....

class Edge{
	int src;
	int dest;
	int weight;
}

class Graph{
	int V;
	int E;
	Edge[] edge;

	Graph(int v, int e){
		V = v;
		E = e;
		edge = new Edge[e];

		for(int i=0; i<e; i++){
			edge[i] = new Edge();
		}
	}
}

class DetectNegetiveCycle{
	public static void main(String[] args) {
		Graph g = new Graph(4, 4);

		g.edge[0].src = 0;
		g.edge[0].dest = 1;
		g.edge[0].weight = -10;

		g.edge[1].src = 0;
		g.edge[1].dest = 3;
		g.edge[1].weight = 1;

		g.edge[2].src = 1;
		g.edge[2].dest = 2;
		g.edge[2].weight = 1;

		g.edge[3].src = 2;
		g.edge[3].dest = 3;
		g.edge[3].weight = 1;

		DetectNegetiveCycle dnc = new DetectNegetiveCycle();
		System.out.print(dnc.detectNegetiveCycle(g, 4, 4));
	}

	boolean detectNegetiveCycle(Graph g, int V, int E){
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

		int start = 0;
		dist[start] = 0;

		for(int i=0; i<V-1; i++){
			
			for(int j=0; j<E; j++){
				int u = g.edge[j].src;
				int v = g.edge[j].dest;
				if(dist[u] != Integer.MAX_VALUE && dist[u]+g.edge[j].weight < dist[v]){
					dist[v] = g.edge[j].weight;
				}
			}
		}

		for(int i=0; i<V-1; i++){
			for(int j=0; j<E; j++){
				int u = g.edge[j].src;
				int v = g.edge[j].dest;
				if(dist[u] != Integer.MAX_VALUE && dist[u]+g.edge[j].weight < dist[v]){
					return true;
				}
			}
		}

		return false;
	}
}