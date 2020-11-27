import java.util.*;

class Sol{
	void cyclicSort(int[] a, int length) {
		int i=0;
		while (i<length) {
			int currNum = a[i];
			int shouldBeNum = i+1;
			if(currNum != shouldBeNum){
				swap(a,currNum,shouldBeNum);
			} else {
				i++;
			}
		}
	}

	void swap(int[] a, int currNum, int shouldBeNum) {
		int temp = a[currNum-1];
		a[currNum-1] = a[shouldBeNum-1];
		a[shouldBeNum-1] = temp;
	}
}

class CyclicSort{
	public static void main(String[] args) {
		int[] a = {3,4,1,2,5};
		int length = a.length;
		Sol sol = new Sol();
		sol.cyclicSort(a, length);

		for(Integer i : a){
			System.out.print(i+" ");
		}
	}
} 