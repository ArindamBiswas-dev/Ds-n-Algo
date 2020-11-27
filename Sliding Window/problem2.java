import java.util.*;

class Sol{
	ArrayList<Integer> solution(String s, String pattern){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int sLen = s.length();
		int pLen = pattern.length();
		int windowStart = 0;
		int matched = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i=0;i<pLen;i++){
			map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0)+1);
		}
	//	System.out.println(map);

		for(int windowEnd=0; windowEnd<sLen; windowEnd++){

			char c = s.charAt(windowEnd);

			if(map.containsKey(c)){
				map.put(c, map.get(c)-1);
				if(map.get(c) == 0){
					matched += 1;
				}
			}

			if(matched == pLen){
		//		System.out.println("Start : " +windowStart);
				list.add(windowStart);
			}

			if(windowEnd-windowStart == pLen-1){
				char l = s.charAt(windowStart);
				if(map.containsKey(l)){
					if(map.get(l) == 0){
						matched -= 1;
					}
					map.put(l, map.get(l)+1);
		//			System.out.println(map);
				}
				windowStart++;
			}
		}
		return list;
	}
}

class problem2{
	public static void main(String[] args) {
		String s = "aabdec";
		String pattern = "abc";
		Sol sol = new Sol();
		ArrayList<Integer> a = sol.solution(s,pattern);
		System.out.println(a);
		// for( Integer i : a){
		// 	System.out.print(i+" ");
		// }
	}
}