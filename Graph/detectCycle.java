import java.util.*;

class cycle{

	static boolean haveCycle(ArrayList<ArrayList<Integer>> g,int V){
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			visited[i] = false;
		}
		for(int i=0;i<V;i++){			// this loop is for dis-connected graph
			if(visited[i] == false){
				if(isCycle(g,i,-1,visited)){
				return true;
				}
			}
		}
		return false;
	}

	static boolean isCycle(ArrayList<ArrayList<Integer>> g,int index,int parent,boolean[] visited){
		visited[index] = true;
		for(int i=0;i<g.get(index).size();i++){
			if(visited[g.get(index).get(i)] == false){
				isCycle(g,g.get(index).get(i),index,visited);
			}
			else if(g.get(index).get(i) != parent){
				return true;
			}
		}
		return false;
	}
}


class detectCycle{

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
		addEdge(graph,0,1);
		addEdge(graph,0,3);
		addEdge(graph,1,4);
		addEdge(graph,2,3);
		addEdge(graph,4,2);

		System.out.print(cycle.haveCycle(graph,V));
		
	}
}