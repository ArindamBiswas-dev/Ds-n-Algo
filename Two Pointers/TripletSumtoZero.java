import java.util.*;

class Sol{
	void solution(int[] a, int len, ArrayList<ArrayList<Integer>> list){

		for(int i=0;i<len-2;i++){
			if(i > 0 && a[i] == a[i-1]){
				continue;
			}
			else{
				int x = a[i];
				solUtil(a,i+1,len,list,x);
			}
		}
	}

	void solUtil(int[] a, int index, int len, ArrayList<ArrayList<Integer>> list,int x){
		int y = index;
		int z = len-1;
		int target = x * -1;
		while(y < z){

			if(target+a[y]+a[z] == 0) {
				ArrayList<Integer> alist = new ArrayList<Integer>();
				alist.add(a[index-1]);
				alist.add(a[y]);
				alist.add(a[z]);
				list.add(alist);
				y++;
				z--;
			}

			else if(a[y]+a[z] < target) {
				y++;
			} 

			else{
				z--;
			}

		}
	}

}

class TripletSumtoZero{
	public static void main(String[] args) {
		int[] a = {-3, 0, 1, 2, -1, 1, -2};
		Arrays.sort(a);	
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Sol sol = new Sol();
		sol.solution(a,a.length,list);
		System.out.print(list);
	}
}