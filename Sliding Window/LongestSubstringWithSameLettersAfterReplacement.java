import java.util.*;

class Sol{
	int solution(int k,String s,int length){
		int maxLength = 0;
		int maxFreq = 0;
		int windowStart = 0;
		int startingIndex = -1;
		int endingIndex = -1;
		HashMap<Character, Integer> map = new HashMap<>();

		for(int windowEnd=0; windowEnd<length; windowEnd++){

			map.put(s.charAt(windowEnd), map.getOrDefault(s.charAt(windowEnd), 0) +1);

			maxFreq = Math.max(map.get(s.charAt(windowEnd)), maxFreq);

			if(windowEnd - windowStart + 1 - maxFreq > k){
				windowStart++;
			}

			// maxLength = Math.max(windowEnd - windowStart + 1, maxLength);

			if(windowEnd - windowStart + 1 > maxLength){		// if we want to know about the substring, we are storing the starting and ending inde-1
				startingIndex = windowStart;
				endingIndex = windowEnd;
				maxLength = windowEnd - windowStart + 1;
			}
		}

		for(int i=startingIndex; i<endingIndex+1; i++){
			System.out.print(s.charAt(i)+" ");
		}
		System.out.println();


		return maxLength;
	}
}

class LongestSubstringWithSameLettersAfterReplacement{
	public static void main(String[] args) {
		int k = 1;
		String s = "abbcb";
		int length = s.length();
		Sol sol = new Sol();
		System.out.print(sol.solution(k,s,length));
	}
}