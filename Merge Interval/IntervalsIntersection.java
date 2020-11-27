import java.util.*;

class Sol{
	void intervalInsertion(int[][] interval1, int[][] interval2){
		List<int[]> l = new ArrayList<>();
		int i2 = 0;

		for(int[] i : interval1){
			int start = i[0];
			int end = i[1];

			if(end >= interval2[i2][0]){
				end = Math.max(end, interval2[i2][1]);
				start = Math.min(start, interval2[i2][0]);
				l.add(new int[]{start, end});
				i2++;
			} else {
				l.add(new int[]{start, end});
			}
		}

		for(int[] i : l){
			System.out.println(i[0]+" "+i[1]);
		}
	}
}

class IntervalsIntersection{
	public static void main(String[] args) {
		int[][] interval1 = {
			{1,3},
			{5,6},
			{7,9},
		};

		int[][] interval2 = {
			{0,4},
			{8,10},
		};

		Sol sol = new Sol();
		sol.intervalInsertion(interval1, interval2);
	}
}