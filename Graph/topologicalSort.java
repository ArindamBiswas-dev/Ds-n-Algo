import java.util.ArrayList; 
import java.util.LinkedList; 
import java.util.List;
import java.util.Stack;


class topologicalSort{

	List<List<Integer>> adj;

	topologicalSort(int v){

		adj = new ArrayList<>(v);
		for(int i=0;i<v;i++){
			adj.add(new LinkedList<>());
		}
	}

	void addEdge(int source,int destination){
		adj.get(source).add(destination);
	}

	void topoSortUtil(int node,boolean[] visited,Stack<Integer> st){
		visited[node] = true;
		List<Integer> children = adj.get(node);
		for(Integer it : children){
			if(!visited[it]){
				topoSortUtil(it,visited,st);
			}
		}
		st.push(node);
	}

	void topoSort(int v){
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[v];
		for(int i=0;i<v;i++){
			if(!visited[i]){
				topoSortUtil(i,visited,st);
			}
		}

		while(!st.empty()){
			System.out.print(st.pop() + " ");
		}
	}

	public static void main(String[] args) {
		topologicalSort g = new topologicalSort(6);
		g.addEdge(5,0);
		g.addEdge(5,2);
		g.addEdge(2,3);
		g.addEdge(3,1);
		g.addEdge(4,0);
		g.addEdge(4,1);
		g.topoSort(6);
	}
}