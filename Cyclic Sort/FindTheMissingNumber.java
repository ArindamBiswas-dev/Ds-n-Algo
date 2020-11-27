import java.util.*;

class Sol{
	int findTheMissingNumber(int[] a, int length) {
		cyclicSort(a,length);
		
		// for(Integer i : a){
		// 	System.out.print(i+" ");
		// }

		for(int i=0; i<length; i++){
			if(a[i] != i){
				return i;
			}
		}

		return -1;
	}

	void cyclicSort(int[] a, int length){
		int i = 0;
		while(i < length){
			int currNum = a[i];
			int shouldBeNUm = i;
			if(currNum < length && currNum != shouldBeNUm){
				swap(a, currNum, shouldBeNUm);
			} else {
				i++;
			}
		}
	}

	void swap(int[] a, int currNum, int shouldBeNUm) {
		int temp = a[shouldBeNUm];
		a[shouldBeNUm] = a[currNum];
		a[currNum] = temp;
	}
}

class FindTheMissingNumber{
	public static void main(String[] args) {
		int[] a = {8, 3, 5, 2, 4, 6, 0, 1};
		int length = a.length;

		Sol sol = new Sol();
		System.out.print(sol.findTheMissingNumber(a, length));
	}
}