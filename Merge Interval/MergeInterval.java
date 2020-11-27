import java.util.*;

class Sol{
	
	void mergeIntervalBrute(int[][] interval){
		List<int[]> l = new ArrayList<>();

		for(int i=0; i<interval.length; i++){
			int start = interval[i][0];
			int end = interval[i][1];
			for(int j=i+1; j<interval.length; j++){
				if(end >= interval[j][0]){
					end = Math.max(interval[j][1], end);
					i++;
				}
			}
			l.add(new int[] {start, end});
		}
		for(int[] k : l){
			System.out.println(k[0]+" "+k[1]);
		}
		
	}

	void mergeIntervalOptimal(int[][] interval){
		List<int[]> l = new ArrayList<>();
		int start = interval[0][0];
		int end = interval[0][1];

		for(int[] a : interval){
			if(end >= a[0]){
				end = Math.max(end, a[1]);
			} else {
				l.add(new int[]{start, end});
				start = a[0];
				end = a[1];
			}
		}
		l.add(new int[]{start, end});

		for(int[] k : l){
			System.out.println(k[0]+" "+k[1]);
		}
	}
}

class MergeInterval{
	public static void main(String[] args) {
		
		int[][] interval = {

							{1,3},
							{2,6},
							{8,10},
							{9,9},
							{15,18},

							};
		Arrays.sort(interval, (a1,b1) -> a1[0]-b1[0]);
		Sol sol = new Sol();
		System.out.println("mergeIntervalBrute");
		sol.mergeIntervalBrute(interval);
		System.out.println("mergeIntervalOptimal");
		sol.mergeIntervalOptimal(interval);
	}
}