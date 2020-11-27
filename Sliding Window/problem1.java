import java.util.*;

class Sol{
	boolean solution(String s, String pattern){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int sLen = s.length();
		int pLen = pattern.length();
		int windowStart = 0;
	//	int windowEnd = 0;
		int matched = 0;

		for(int i=0;i<pLen;i++){
			map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0)+1);
		}
		System.out.println(map);

		for(int windowEnd=0; windowEnd<sLen; windowEnd++){

			char c = s.charAt(windowEnd);

			if(map.containsKey(c)){
				map.put(c, map.get(c)-1);
				System.out.println(map);
				if(map.get(c) == 0){
					matched += 1;
				}
			}

			if(matched == pLen){
				System.out.println("Start : " +windowStart);
		//		System.out.println("End : "+windowEnd);
				return true;
			}

			if(windowEnd-windowStart == pLen-1){
				char l = s.charAt(windowStart);
				if(map.containsKey(l)){
					if(map.get(l) == 0){
						matched -= 1;
					}
					map.put(l, map.get(l)+1);
					System.out.println(map);
				}
				windowStart++;
			}
		}
		return false;
	}
}

class problem1{
	public static void main(String[] args) {
		String s = "aabc";
		String pattern = "abc";
		Sol sol = new Sol();
		System.out.print(sol.solution(s,pattern));
	}
}