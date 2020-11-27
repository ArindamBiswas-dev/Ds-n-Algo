import java.util.*;

class Sol{
	int solution(int[] a, int length, int target){
		ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
		int count = 0;
		for(int x=0; x<length; x++){
			int y = x+1;
			int z = length-1;
			while(y < z) {
				int sum = a[x]+a[y]+a[z];
				if(sum < target){
					count += z-y;

					for(int k=z; k>y; k--){
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(a[x]);
						list.add(a[y]);
						list.add(a[k]);
						aList.add(list);
					}
					y++;
				} else {
					z--;
				}
			}
		}
		System.out.println(aList);
		return count;
	}
}

class TripletsWithSmallerSum{
	public static void main(String[] args) {
		int target = 5;
		int[] a = {-1, 4, 2, 1, 3};
		Arrays.sort(a);
		Sol sol = new Sol();
		System.out.print(sol.solution(a,a.length,target));
	}
}