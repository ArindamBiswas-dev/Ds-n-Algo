import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List;
import java.util.Stack;

class connectedComponent{
	List<List<Integer>> adj;

	connectedComponent(int v){

		adj = new ArrayList<>(v);
		for(int i=0;i<v;i++){
			adj.add(new LinkedList<>());
		}
	}

	void noOfConnectedComponentUtil(boolean[] visited,int node){
		visited[node] = true;
		List<Integer> children = adj.get(node);
		for(Integer it : children){
			if(!visited[it]){
				noOfConnectedComponentUtil(visited,it);
			}
		}
	}

	int noOfConnectedComponent(int v){
		boolean[] visited = new boolean[v];
		int count = 0;
		for(int i=0;i<v;i++){
			if(!visited[i]){
				noOfConnectedComponentUtil(visited,i);
				count++;
			}
		}
		return count;
	}

	void addEdge(int source,int destination){
		adj.get(source).add(destination);
		adj.get(destination).add(source);
	}

	public static void main(String[] args) {
		connectedComponent g = new connectedComponent(6);
		int v = 6;
		g.addEdge(0,1);
		g.addEdge(2,3);
		g.addEdge(4,5);
		// g.addEdge(1,3);
		// g.addEdge(4,5);
		System.out.print(g.noOfConnectedComponent(v));
	}
}