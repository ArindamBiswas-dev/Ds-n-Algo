import java.util.*;

class Sol{
	boolean isConflict(int[][] interval){
		Arrays.sort(interval, (a,b) -> a[0]-b[0]);

		int end = Integer.MIN_VALUE;
		int start = Integer.MAX_VALUE;

		for(int[] i : interval){
			start = i[0];
			if(end > start) {
				return false;
			}
			end = i[1];
		}
		return true;
	}

	void totalConflict(int[][] interval){

		Arrays.sort(interval, (a,b) -> a[0]-b[0]);

		int currEnd = Integer.MIN_VALUE;
		int currStart = Integer.MAX_VALUE;

		int prevEnd = Integer.MIN_VALUE;
		int prevStart = Integer.MAX_VALUE;

		for(int[] i : interval){

			currStart = i[0];
			currEnd = i[1];

			if(prevEnd > currStart) {
				System.out.println("["+prevStart+","+prevEnd+"] conflict with "+"["+currStart+","+currEnd+"]");
				if(prevEnd < currEnd){
					prevEnd = currEnd;
					prevStart = currStart;
				}
			} else {
				prevStart = i[0];
				prevEnd = i[1];
			}

		}
	}
	
}

class ConflictingAppointments{
	public static void main(String[] args) {
		int[][] interval = {
			{4,5},
			{2,3},
			{3,6},
			{5,7},
			{6,8},
			{7,8},
		};

		Sol sol = new Sol();
		System.out.println(sol.isConflict(interval));
		sol.totalConflict(interval);
	}
}