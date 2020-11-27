import java.util.*;

class Sol{
	ArrayList<Integer> solution(int[] a,int targetSum){
		int len = a.length;
		int first = 0;
		int last = len-1;
		ArrayList<Integer> aList = new ArrayList<Integer>();
		while(first < last){
			if(a[first] + a[last] > targetSum){
				last--;
			} else if(a[first] + a[last] < targetSum){
				first++;
			} else {
				aList.add(first);
				aList.add(last);
				first++;
				last--;
			}
		}
		return aList;
	}
}

class PairwithTargetSum{
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 6};
		int targetSum = 5;
		Sol sol = new Sol();
		System.out.print(sol.solution(a,targetSum));
	}
}