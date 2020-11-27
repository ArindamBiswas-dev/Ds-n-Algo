import java.util.*;

class Sol{
	void solution(int[] a){
		int len = a.length;
		int firstPointer = 0;
		int secondPointer = len-1;

		while(firstPointer < secondPointer) {
			if(a[firstPointer]*a[firstPointer] > a[secondPointer]*a[secondPointer]) {
				int temp = a[firstPointer];
				a[firstPointer] = a[secondPointer];
				a[secondPointer] = temp;
			}
			secondPointer--;
		}
	}
}

class SquaringaSortedArray{
	public static void main(String[] args) {
		int[] a = {-2, -1, 0, 2, 3};
		Sol sol = new Sol();
		sol.solution(a);
		for(Integer i : a) {
			System.out.print(i+" ");
		}
	}
}