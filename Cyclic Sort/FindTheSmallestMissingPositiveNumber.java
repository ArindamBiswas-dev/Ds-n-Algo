import java.util.*;

class Sol{
	int findMissing(int[] a, int length){
		cyclicSort(a, length);

		// for(Integer k : a){
		// 	System.out.print(k+" ");
		// }

		for(int i=0; i<length; i++){
			if(a[i] != i+1){
				return i+1;
			}
		}

		return -1;
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

class FindTheSmallestMissingPositiveNumber{
	public static void main(String[] args) {
		int[] a = {-3, 1, 5, 4, 2};
		int length = a.length;

		Sol sol = new Sol();
		System.out.print(sol.findMissing(a, length));
	}
}