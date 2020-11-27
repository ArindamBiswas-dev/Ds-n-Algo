import java.util.*;

class Sol{
	void findMedian(int[] a, int length){
		int[] sortedList = new int[length];
		for(int i=0; i<length; i++){
			// sortedList[i] = a[i];  // un-comment it for the insertion sort method
			double medianSoFar = findMedianUtil(a[i], sortedList, i+1);
			System.out.println(medianSoFar);
		}
	}
	double findMedianUtil(int x, int[] sortedList, int length){
		
		//	****** USING INSERTION SORT ******  O(n^2)	-> total complexity O(n^3)

		// for(int i=0; i<length; i++){
		// 	int j = i;
		// 	while(j > 0 && sortedList[j-1] > sortedList[j]){
		// 		int temp = sortedList[j];
		// 		sortedList[j] = sortedList[j-1];
		// 		sortedList[j-1] = temp;
		// 		j--;
		// 	}
		// }

		//	****** USING INSERT an Element into a Sorted List ******  O(n)	-> total complexity O(n^2)

		int index = length-1;
		for(int i=0; i<length-1; i++){
			if(sortedList[i] > x){
				index = i;
				break;
			}
		}

		for(int i=length-1; i>index; i--){
			sortedList[i] = sortedList[i-1];
		}
		sortedList[index] = x;



		//   commone for both method
		
		int mid = (length-1)/2;
		if(length % 2 == 0){
			return (double)(sortedList[mid] + sortedList[mid+1])/2;
		} else {
			return sortedList[mid];
		}

	}
}

class FindtheMedianofaNumberStream{
	public static void main(String[] args) {
		int[] a = {3,1,5,4};
		int length = a.length;

		Sol sol = new Sol();
		sol.findMedian(a, length);
	}
}