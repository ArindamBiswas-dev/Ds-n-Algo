import java.util.*;

class InsertInSortedList{
	public static void main(String[] args) {
		int[] a = new int[5];
		a[0] = 1;
		a[1] = 3;
		a[2] = 4;
		a[3] = 5;

		int x = 2;
		int index = a.length-1;

		for(int i=0; i<5; i++){
			if(a[i] > x){
				index = i;
				break;
			}
		}
		// System.out.print(index);

		for(int i=a.length-1; i>=index; i--){
			a[i] = a[i-1];
		}
		a[index] = x;

		for(Integer i : a){
			System.out.print(i+" ");
		}
	}
}