import java.util.*;

class Sol{
	int solution(String s, String sRev, int length, int[][] t){
		
		for(int i=1; i<length+1; i++){
			for(int j=1; j<length+1; j++){
				if(s.charAt(i-1) == sRev.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				} else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}

		return t[length][length];
	}
}

class DeletiontoMakePalindrome{
	public static void main(String[] args) {
		String s = "aebcbda";
		String sRev = "adbcbea";
		int len = s.length();
		int[][] t = new int[len+1][len+1];

		for(int i=0;i<len+1;i++){
			for(int j=0;j<len+1;j++){
				if(i == 0 || j == 0){
					t[i][j] = 0;
				}
			}
		}

		Sol sol = new Sol();
		int lcsLength = sol.solution(s,sRev,len,t);
		System.out.print(len - lcsLength);
	}
}