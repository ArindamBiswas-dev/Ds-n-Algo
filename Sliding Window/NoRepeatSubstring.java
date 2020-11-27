import java.util.*;

class Sol{
	int solution(String s,int length){
		HashSet<Character> set = new HashSet<Character>();
		int currLength = 0;
		int maxLength = Integer.MIN_VALUE;
		int windowStart = 0;
		int windowEnd = 0;

		for(windowEnd=0; windowEnd<length; windowEnd++) {
			if(!set.contains(s.charAt(windowEnd))) {
				set.add(s.charAt(windowEnd));
			} else {
				currLength = set.size();
				set.clear();
				if(currLength > maxLength) {
					maxLength = currLength;
				}
				windowEnd--;
			}
		}
		return maxLength;
	}
}

class NoRepeatSubstring{
	public static void main(String[] args) {
		String s = "abbcdeaafg";
		int length = s.length();
		Sol sol = new Sol();
		System.out.print(sol.solution(s,length));
	}
}