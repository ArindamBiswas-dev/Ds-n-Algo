import java.util.*;

class Sol{
	void insertInterval(int[][] interval, int[] insert){
		List<int[]> l = new ArrayList<>();
		int istart = insert[0];
		int iend = insert[1];

		for(int[] i : interval){
			int start = i[0];
			int end = i[1];
			if(end >= istart){
				end = Math.max(end, iend);
				start = Math.min(start, istart);
				l.add(new int[]{start, end});
				istart = Integer.MAX_VALUE;
			} else {
				l.add(new int[]{start, end});
			}
		}

		for(int[] i : l){
			System.out.println(i[0]+" "+i[1]);
		}
	}
}

class InsertInterval{
	public static void main(String[] args) {
		int[][] interval = {
			{1,4},
			{6,7},
			{10,13},
		};
		int[] insert = {0,3};

		Sol sol = new Sol();
		sol.insertInterval(interval, insert);
	}
}