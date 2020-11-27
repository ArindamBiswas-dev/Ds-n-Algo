import java.util.*;

class avgOfsizeK{
	public static void main(String[] args) {
		int[] a = {1, 3, 2, 6, -1, 4, 1, 8, 2};
		int k = 5;
		ArrayList<Double> res = new ArrayList<Double>();

		double currSum = 0;
		int windowStart = 0;
		// int windowEnd = 0;

		for(int windowEnd = 0; windowEnd<a.length; windowEnd++){

			currSum += a[windowEnd];

			if(windowEnd >= k-1){
				res.add(currSum/5);
				currSum -= a[windowStart];
				windowStart++;
			}

		}

		System.out.print(res);
	}
}