import java.util.*;

class JourneyToMoon{
	public static void main(String[] args) {
		int[][] edgeList = {
							{0, 1},
							{2, 3},
							{0, 4}
						};
		int totalAstronut = 5;

		JourneyToMoon jm = new JourneyToMoon();
		System.out.print(jm.findPairs(edgeList, totalAstronut));
	}

	int findPairs(int[][] edgeList, int n){
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();	// creation of graph
		for(int i=0; i<n; i++){
			g.add(new ArrayList());
		}

		for(int[] edge : edgeList){		// adding the edges
			int u = edge[0];
			int v = edge[1];
			g.get(u).add(v);
			g.get(v).add(u);
		}

		boolean[] visited = new boolean[n];
		ArrayList<Integer> countryCount = new ArrayList<Integer>();

		for(int i=0; i<n; i++){
			if(visited[i] == false){
				countryCount.add(dfs(g, i, visited));
				System.out.println(countryCount);
			}
		}

		int sum = 0;
		int totalPairs = 0;
		for(Integer count : countryCount){
			totalPairs += sum * count;
			sum += count;
		}

		return totalPairs;
	}

	int dfs(ArrayList<ArrayList<Integer>> g, int curr, boolean[] visited){
		visited[curr] = true;
		int count = 1;

		for(Integer i : g.get(curr)){
			if(visited[i] == false)
				count += dfs(g, i, visited);	// summing up the total no of adj. nodes
		}

		return count;
	}
}