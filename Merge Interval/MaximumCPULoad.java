import java.util.*;

class Sol{
	int maxLoad(int[][] interval){
		Arrays.sort(interval, (a,b) -> a[0]-b[0]);
		int currload = 0;
		int maxLoad = Integer.MIN_VALUE;
		int start;
		int end = -1;

		for(int[] i : interval){
			start = i[0];
			if(start <= end){
				currload += i[2];
			} else {
				maxLoad = (maxLoad < currload) ? currload : maxLoad;
				currload = i[2];
			}
			end = i[1];
		}
		maxLoad = (maxLoad < currload) ? currload : maxLoad;
		return maxLoad;
	}
}

class MaximumCPULoad{
	public static void main(String[] args) {
		int[][] interval = {
			{1,4,2},
			{2,4,1},
			{3,6,5},
		};
		Sol sol = new Sol();
		System.out.print(sol.maxLoad(interval));
	}
}