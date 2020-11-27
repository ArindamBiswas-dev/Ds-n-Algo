import java.util.*;

class Sol{
	String SCS(String a, String b, int len1, int len2, int[][] t){

		for(int i=1;i<len1+1;i++){
			for(int j=1;j<len2+1;j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					t[i][j] = 1 + t[i-1][j-1];
				} else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}

		char[] charArray = new char[len1+len2-t[len1][len2]];
		int i = len1;
		int j = len2;
		int k = len1+len2-t[len1][len2] - 1;

		while(i > 0 && j > 0){
			if(a.charAt(i-1) == b.charAt(j-1)){
				charArray[k--] = a.charAt(i-1);
				i--;
				j--;
			} else {
				if(t[i][j-1] > t[i-1][j]){
					charArray[k--] = b.charAt(j-1);
					j--;
				} else {
					charArray[k--] = a.charAt(i-1);
					i--;
				}
			}
		}

		while(i > 0){
			charArray[k--] = a.charAt(i-1);
			i--;
		}

		while(j > 0){
			charArray[k--] = a.charAt(j-1);
			j--;
		}

		return new String(charArray);
	}
}

class PrintShortesCommonSupersequence{
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

		Sol sol = new Sol();
		String scs = sol.SCS(a,b,len1,len2,t);
		System.out.print(scs);
	}
}

// Hey guys how are you ???