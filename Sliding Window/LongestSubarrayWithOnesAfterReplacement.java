import java.util.*;

class Sol{
	int solution(int[] a,int length,int k){
		int zeroFreq = 0;
		int oneFreq = 0;
		int maxLength = 0;
		int windowStart = 0;

		for(int windowEnd = 0; windowEnd < length; windowEnd++){
			if(a[windowEnd] == 1){
				oneFreq += 1;
			}

			if(windowEnd - windowStart + 1 - oneFreq > k){
				if(a[windowEnd] == 1) oneFreq --;
				windowStart++;
			}
			maxLength = Math.max(windowEnd - windowStart + 1, maxLength);
		}
		return maxLength;
	}
}

class LongestSubarrayWithOnesAfterReplacement{
	public static void main(String[] args) {
		int[] a = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		int length = a.length;
		int k = 3;

		Sol sol = new Sol();
		System.out.print(sol.solution(a,length,k));
	}
}