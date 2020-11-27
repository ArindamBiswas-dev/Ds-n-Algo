class sol{

	// using recursion
	static int solution1(String a1,String a2,int n,int m,int count){
		if(n == 0 || m == 0){
			return count;
		}

		if(a1.charAt(n-1) == a2.charAt(m-1)){
			count = solution1(a1,a2,n-1,m-1,count+1);
		}
		else{
			count = Math.max(count , Math.max(solution1(a1,a2,n-1,m,0), solution1(a1,a2,n,m-1,0)));
		}
		return count;
	}

	static int globalMax = 0;
	static int solution2(String a1,String a2,int n,int m,int count,int[][] t){
		if(n == 0 || m == 0){
			return globalMax;
		}

		if(t[n][m] > globalMax){
			globalMax = t[n][m];
			return globalMax;
		}

		if(a1.charAt(n-1) == a2.charAt(m-1)){
			count = solution2(a1,a2,n-1,m-1,count+1,t);
			if(globalMax < count){
				globalMax = count;
				t[n][m] = globalMax;
			}
		}

		else{
			count = Math.max(count , Math.max(solution2(a1,a2,n-1,m,0,t), solution2(a1,a2,n,m-1,0,t)));
			if(globalMax < count){
				t[n][m] = globalMax;
			}
		}
		return globalMax;
	}
}

class longestCommoneSubstring{
	public static void main(String[] args) {
		String a1 = "abceddef";
		String a2 = "abcfddefxyz";
		System.out.println(sol.solution1(a1,a2,a1.length(),a2.length(),0));

		int[][] t = new int[a1.length()+1][a2.length()+1];
		for(int i=0;i<a1.length()+1;i++){
			for(int j=0;j<a2.length()+1;j++){
				if(i == 0 || j == 0){
					t[i][j] = 0;
				}else{
					t[i][j] = -1;
				}
			}
		}
		System.out.println(sol.solution2(a1,a2,a1.length(),a2.length(),0,t));
		for(int i=0;i<a1.length()+1;i++){
			for(int j=0;j<a2.length()+1;j++){
				System.out.print(t[i][j]);
			}
			System.out.println();
		}
	}
}