import java.util.ArrayList; 
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

class KosarajusAlgo{			// strongly connected graph
	List<List<Integer>> adj;

	KosarajusAlgo(int v){

		adj = new ArrayList<>(v);
		for(int i=0;i<v;i++){
			adj.add(new LinkedList<>());
		}
	}

	void fillStack(int node,Stack st,boolean[] visited){
		visited[node] = true;
		List<Integer>  children = adj.get(node);
		for(Integer it : children){
			if(visited[it] == false){
				fillStack(it,st,visited);
			}
		}
		st.push(node);
	}

	KosarajusAlgo transposeGraph(int v){
		KosarajusAlgo reverseGraph = new KosarajusAlgo(v);

		for(int i=0;i<v;i++){
			List<Integer> children = adj.get(i);
			for(Integer it : children){
				reverseGraph.addEdge(it,i);
			}
		}
		return reverseGraph;
	}

	void dfs(int node,boolean[] visited){
		visited[node] = true;
		List<Integer>  children = adj.get(node);
		for(Integer it : children){
			if(visited[it] == false){
				dfs(it,visited);
			}
		}
	}

	int noOfStronglyConnectedComp(int v){
		Stack st = new Stack();
		boolean[] visited = new boolean[v];

		for(int i=0;i<v;i++){
			if(!visited[i]){
				fillStack(0,st,visited);
			}
		}

		KosarajusAlgo reverseGraph = transposeGraph(v);

		int count = 0;
		Arrays.fill(visited,false);
		while(!st.empty()){
			if(!visited[(int)st.peek()]){
				reverseGraph.dfs((int)st.peek(),visited);
				count++;
			}
			st.pop();
		}
		return count;
	}

	void addEdge(int source,int destination){
		adj.get(source).add(destination);
	}

	public static void main(String[] args) {
		int v = 5;
		KosarajusAlgo g = new KosarajusAlgo(v);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(0,3);
		g.addEdge(3,4);
		System.out.print(g.noOfStronglyConnectedComp(v));
	}
}