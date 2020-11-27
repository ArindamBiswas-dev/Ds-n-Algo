import java.util.*;

class Sol{
	void findTheCorruptPair(int[] a, int length){
		int[] ans = new int[2];

		cyclicSort(a, length);

		for(Integer x : a){
			System.out.print(x+" ");
		}
		System.out.println();

		for(int i=0; i<length-1; i++){
			if(a[i] > a[i+1]){
				ans[0] = a[i+1];
				ans[1] = a[i]+1;
				break;
			}
		}

		for(Integer y : ans){
			System.out.print(y+" ");
		}
	}

	void cyclicSort(int[] a, int length){
		int i = 0;

		while(i < length){
			int currSum = a[i];
			int shouldBeSum = i+1;
			if(currSum != a[currSum-1] && currSum != shouldBeSum){
				swap(a, currSum, shouldBeSum);
			} else {
				i++;
			}
		}
	}

	void swap(int[] a, int currSum, int shouldBeSum){
		int temp = a[currSum-1];
		a[currSum-1] = a[shouldBeSum-1];
		a[shouldBeSum-1] = temp;
	}
}

class FindTheCorruptPair{
	public static void main(String[] args) {
		int[] a = {3, 1, 2, 3, 6, 4};
		int length = a.length;
		Sol sol = new Sol();
		sol.findTheCorruptPair(a, length);
	}
}