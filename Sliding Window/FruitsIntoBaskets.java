import java.util.*;

class Sol{
	int solution(char[] tree, int length){
		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		int windowStart = 0;
		int windowEnd = 0;

		for(windowEnd=0; windowEnd<length; windowEnd++){

			if(map1.containsKey(tree[windowEnd]) || map1.size() < 2) {
				int count = map1.getOrDefault(tree[windowEnd],0) + 1;
				map1.put(tree[windowEnd],count);
			} else {
				map1.remove(tree[windowStart]);
				windowStart++;
				windowEnd--;
			}

		}
		int count = 0;
		for(Map.Entry m : map1.entrySet()){
			count += (int) m.getValue();
		}
		return count;
	}
}

class FruitsIntoBaskets{
	public static void main(String[] args) {
		char[] tree = {'A', 'B', 'C', 'B', 'B', 'C'};
		int length = tree.length;
		Sol sol = new Sol();
		System.out.print(sol.solution(tree,length));
	}
}