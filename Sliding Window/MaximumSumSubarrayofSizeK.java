import java.util.*;

class MaximumSumSubarrayofSizeK{
	public static void main(String[] args) {
		int[] a = {2, 1, 5, 1, 3, 2};
		int k = 3;
		int maxSum = Integer.MIN_VALUE;
		int currSum = 0;
		int windowStart = 0;

		for(int windowEnd = 0; windowEnd<a.length; windowEnd++){
			currSum += a[windowEnd];
			if(windowEnd >= k-1){
				if(currSum > maxSum){
					maxSum = currSum;
				}
				currSum -= a[windowEnd-(k-1)];
				windowStart++;
			}
		}

		System.out.print(maxSum);
	}
}