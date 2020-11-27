import java.util.*;

class Sol{
	void findAllMissingNumbers(int[] a,int length){
		cyclicSort(a,length);
		ArrayList<Integer> aList = new ArrayList<>();

		for(int i=0; i<length; i++) {
			if(a[i] != i+1){
				aList.add(i+1);
			}
		}

		for(Integer i : aList) {
			System.out.print(i+" ");
		}
	}

	void cyclicSort(int[] a, int length) {
		int i=0;
		while (i<length) {
			int currNum = a[i];
			int shouldBeNum = i+1;
			if(currNum != a[currNum-1] && currNum != shouldBeNum){
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

class FindAllMissingNumbers{
	public static void main(String[] args) {
		int[] a = {2, 3, 1, 8, 2, 3, 5, 1};
		int length = a.length;

		Sol sol = new Sol();
		sol.findAllMissingNumbers(a,length);
	}
}