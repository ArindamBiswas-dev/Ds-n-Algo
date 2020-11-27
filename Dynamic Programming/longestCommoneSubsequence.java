class sol{

	// Recursive approach
	static int solution1(char[] a1,char[] a2,int n,int m){
		if(n == 0 || m == 0){
			return 0;
		}

		if(a1[n-1] == a2[m-1]){
			return 1 + solution1(a1,a2,n-1,m-1);
		}
		return Math.max(solution1(a1,a2,n,m-1), solution1(a1,a2,n-1,m));
	}

	// Memorization approach
	static int solution2(char[] a1,char[] a2,int n,int m,int[][] t){
		if(n == 0 || m == 0){
			return 0;
		}
		if(t[n][m] != -1){
			return t[n][m];
		}

		if(a1[n-1] == a2[m-1]){
			t[n][m] = 1 + solution2(a1,a2,n-1,m-1,t);
			return t[n][m];
		}
		t[n][m] = Math.max(solution2(a1,a2,n,m-1,t), solution2(a1,a2,n-1,m,t));
		return t[n][m];
	}

	// Bottom Up approach
	static int solution3(char[] a1,char[] a2,int n,int m,int[][] t){
		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				if(a1[i-1] == a2[j-1]){
					t[i][j] = 1 + t[i-1][j-1];
				}else{
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		return t[n][m];
	}
}

class longestCommoneSubsequence{
	public static void main(String[] args) {
		char[] a1 = {'a','b','d','c','e'};
		char[] a2 = {'a','b','c','d'};
		int[][] t = new int[a1.length+1][a2.length+1];

		for(int i=0;i<a1.length+1;i++){
			for(int j=0;j<a2.length+1;j++){
				if(i == 0 || j == 0){
					t[i][j] = 0;
				}
			}
		}
		System.out.println(sol.solution3(a1,a2,a1.length,a2.length,t));

		for(int i=0;i<a1.length+1;i++){
			for(int j=0;j<a2.length+1;j++){
				if(i == 0 || j == 0){
					t[i][j] = 0;
				}
				if(i != 0 && j != 0){
					t[i][j] = -1;
				}
			}
		}
		System.out.println(sol.solution1(a1,a2,a1.length,a2.length));
		System.out.println(sol.solution2(a1,a2,a1.length,a2.length,t));
	}
}