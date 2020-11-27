class printLongestCommoneSubsequence{

	void printLong(String x,String y,int[][] t){

		for(int i=1;i<x.length()+1;i++){
			for(int j=1;j<y.length()+1;j++){

				if(x.charAt(i-1) == y.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				}
				else{
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}

	}

	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "aedfhr";
		int[][] t = new int[x.length()+1][y.length()+1];

		for(int i=0;i<x.length()+1;i++){
			for(int j=0;j<y.length()+1;j++){
				if(i == 0 || j == 0){
					t[i][j] = 0;
				}
			}
		}

		printLongestCommoneSubsequence plcs = new printLongestCommoneSubsequence();
		plcs.printLong(x,y,t);

		// System.out.print(x+" ");
		// System.out.print(y+" ");

		int xLen = x.length();
		int yLen = y.length();
		char[] c = new char[3];
		int k=0;

		while(xLen > 0 && yLen > 0){
			if(x.charAt(xLen-1) == y.charAt(yLen-1)){
				c[k++] = x.charAt(xLen-1);
				xLen--;
				yLen--;
			}else if(t[xLen][yLen-1] > t[xLen-1][yLen]){
				yLen--;
			}else{
				xLen--;
			}
		}
		
		String lcs = "";
		for(int i=2;i>=0;i--){
			lcs += c[i];
		}
		System.out.print(lcs);
	}
}