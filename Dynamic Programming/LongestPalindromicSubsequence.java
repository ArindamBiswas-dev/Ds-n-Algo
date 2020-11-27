import java.util.*;

class Sol{
	static int solution(String a,String b,int len1,int len2,int[][] t){

		for(int i=1;i<len1+1;i++){
			for(int j=1;j<len2+1;j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				} else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		return t[len1][len2];
	}
}

class LongestPalindromicSubsequence{
	public static void main(String[] args) {
		String a = "agbcba";
		String b = "abcbga";
		int[][] t = new int[a.length()+1][a.length()+1];

		for(int i=0;i<a.length()+1;i++){
			for(int j=0;j<b.length()+1;j++){
				if(i == 0 || j == 0){
					t[i][j] = 0;
				}
			}
		}

		System.out.print(Sol.solution(a,b,a.length(),b.length(),t));
	}
}