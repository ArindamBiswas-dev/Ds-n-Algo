import java.util.*;

class NoofTraingles{
	public static void main(String[] args) {
		int[][] adj1 = {
						{0, 0, 1, 0},
                        {1, 0, 0, 1},
                        {0, 1, 0, 0},
                        {0, 0, 1, 0}
					};
		int V = 4;

		System.out.println(countTraingles(adj1, V, true));

		int[][] adj2 = 	{
				   {0, 1, 1, 0}, 
	               {1, 0, 1, 1}, 
	               {1, 1, 0, 1}, 
	               {0, 1, 1, 0}
				};

		System.out.print(countTraingles(adj2, V, false));
	}

	static int countTraingles(int[][] adj, int V, boolean isDirected){
		int count = 0;

		for(int i=0; i<V; i++){
			for(int j=0; j<V; j++){
				for(int k=0; k<V; k++){
					if(adj[i][j] == 1 && adj[j][k] == 1 && adj[k][i] == 1){
						count++;
					}
				}
			}
		}

		if(isDirected) return count/3;
		return count/6;
	}
}