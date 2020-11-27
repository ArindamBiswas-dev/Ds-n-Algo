import java.util.*;

class Sol{
	int solution(String a,int k){
		HashSet<Character> hash = new HashSet<Character>();
		int currCount = 0;
		int maxCount = Integer.MIN_VALUE;
		int windowStart = 0;
		int windowEnd = 0;
		int length = a.length();

		for(windowEnd=0; windowEnd<length; windowEnd++){

			if(hash.size() < k || hash.contains(a.charAt(windowEnd))){
				hash.add(a.charAt(windowEnd));
				currCount++;
			}else{
				if(currCount > maxCount){
					maxCount = currCount;
				}
				currCount = 0;
				windowStart++;
			}

		}
		return maxCount;
	}
}


class LongestSubstringwithKDistinctCharacters{
	public static void main(String[] args) {
		String a = "cbbebi";
		int k = 3;
		Sol sol = new Sol();
		System.out.print(sol.solution(a,k));
	}
}