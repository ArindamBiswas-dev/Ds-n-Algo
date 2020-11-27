import java.util.*;

class Sol{

	ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();

	ArrayList<ArrayList<Integer>> solution(int[] arr, int length, int target){

		for(int a=0;a<length;a++){

			for(int b=a+1;b<length;b++){

				int c = b+1;
				int d = length-1;

				while(c < d){

					int sum = arr[a]+arr[b]+arr[c]+arr[d];
					if(sum == target){
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(arr[a]);
						list.add(arr[b]);
						list.add(arr[c]);
						list.add(arr[d]);
						aList.add(list);
						c++;
						d--;
					}
					else if(sum < target){
						c++;
					}
					else{
						d--;
					}

				}

			}

		}
		return aList;
	}
}

class QuadrupleSumtoTarget{
	public static void main(String[] args) {
		int[] a = {4, 1, 2, -1, 1, -3};
		int length = a.length;
		int target = 1;
		Arrays.sort(a);
		Sol sol = new Sol();
		System.out.print(sol.solution(a,a.length,target));
	}
}