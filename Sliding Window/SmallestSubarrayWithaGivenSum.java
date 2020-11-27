import java.util.*;

class SmallestSubarrayWithaGivenSum{
	public static void main(String[] args) {
		int[] a = {2, 1, 5, 2, 3, 2};
		int s = 7;
		int sizeOfsubArray = Integer.MAX_VALUE;
		int windowStart = 0;
		int windowEnd = 0;
		int currSum = 0;
		int count = 0;

		for(windowEnd=0;windowEnd<a.length;windowEnd++){
			currSum += a[windowEnd];
			count++;
			while(currSum >= s){
				sizeOfsubArray = Math.min(sizeOfsubArray,count);
				currSum -= a[windowStart];
				windowStart++;
				count--;
			}
		}
		System.out.print(sizeOfsubArray);
	}
}