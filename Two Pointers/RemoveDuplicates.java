import java.util.*;

class Sol{
	ArrayList<Integer> solution(int[] a){
		int len = a.length;
		int firstPointer = 0;
		int secondPointer = 1;
		ArrayList<Integer> aList = new ArrayList<Integer>();
		aList.add(a[firstPointer]);

		while(secondPointer < len){
			if(a[firstPointer] != a[secondPointer]){
				aList.add(a[secondPointer]);
			}
			firstPointer++;
			secondPointer++;
		}
		return aList;
	}
}

class RemoveDuplicates{
	public static void main(String[] args) {
		int[] a = {2, 2, 2, 11};
		Sol sol = new Sol();
		System.out.print(sol.solution(a));
	}
}