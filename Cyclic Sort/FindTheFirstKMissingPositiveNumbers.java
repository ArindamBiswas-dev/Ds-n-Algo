import java.util.*;

class Sol{
	void findKMissing(int[] a, int length, int k){
		cyclicSort(a, length);

		ArrayList<Integer> res = new ArrayList<Integer>();
		int j = 0;
		HashSet<Integer> set = new HashSet<>();

		for(int i=0; i<length; i++){
			if(res.size() < k){
				if(a[i] != i+1){
					res.add(i+1);
					set.add(a[i]);
				}
			}
		}

		j = 1;
		while(res.size() < k){
			if(!set.contains(j+length)){
				res.add(j+length);
			}
			j++;
		}

		for(Integer x : res){
			System.out.print(x+" ");
		}
	}

	void cyclicSort(int[] a, int length){
		int i = 0;
		while (i<length) {
			int j = a[i]-1;
			if(a[i] > 0 && a[i] <= length && a[i] != a[j]){
				swap(a, i, j);
			} else {
				i++;
			}
		}
	}

	void swap(int[] a, int x, int y){
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}

class FindTheFirstKMissingPositiveNumbers{
	public static void main(String[] args) {
		int[] a = {3, -1, 4, 5, 5};
		int length = a.length;
		int k = 3;

		Sol sol = new Sol();
		sol.findKMissing(a, length, k);
	}
}