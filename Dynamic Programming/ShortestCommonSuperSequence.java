import java.util.*;

class Sol{
	int solution(int m,int n,int[][] t,String a,String b){

		for(int i=1;i<m+1;i++){
			for(int j=1;j<n+1;j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				}else{
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		return m+n-t[m][n]; 
	}
}

class ShortestCommonSuperSequence{
	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		int len1 = a.length();
		int len2 = b.length();
		int[][] t = new int[len1+1][len2+1];

		for(int i=0;i<len1+1;i++){
			for(int j=0;j<len2+1;j++){
				if(i == 0 || j == 0){
					t[i][j] = 0;
				}
			}
		}

		Sol sObj = new Sol();
		System.out.print(sObj.solution(len1,len2,t,a,b));
	}
}