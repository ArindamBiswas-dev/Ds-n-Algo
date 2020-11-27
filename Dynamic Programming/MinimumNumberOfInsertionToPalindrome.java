import java.util.*;

class Sol{
	int solution(String s){
		String sRev = "";
		int len = s.length();
		for(int i=len-1;i>=0;i--){
			sRev += s.charAt(i);
		}

		int lcs = Lcs(s,sRev,len);
		return len-lcs;
	}

	int Lcs(String s, String sRev, int len){
		int[][] t = new int[len+1][len+1];

		for(int i=0;i<len+1;i++){
			for(int j=0;j<len+1;j++){
				if(i == 0|| j == 0){
					t[i][j] = 0;
				}
			}
		}

		for(int i=1;i<len+1;i++){
			for(int j=1;j<len+1;j++){
				if(s.charAt(i-1) == sRev.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				} else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}

		return t[len][len];
	}
}

class MinimumNumberOfInsertionToPalindrome{
	public static void main(String[] args) {
		String s = "ab";
		Sol sol = new Sol();
		System.out.print(sol.solution(s));
	}
}