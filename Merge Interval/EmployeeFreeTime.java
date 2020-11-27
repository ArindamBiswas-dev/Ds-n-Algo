import java.util.*;

class Sol{

	// time taken O ( n * log(n) ) && space taken O ( n ) -> (for sorting " n " space taken)

	void findFreeInterval1(int[][] interval){
		List<int[]> list = new ArrayList<>();
		Arrays.sort(interval, (a,b) -> a[0]-b[0]);

		int start;
		int end = Integer.MAX_VALUE;
		for(int[] i : interval){
			start = i[0];
			if(start > end){
				list.add(new int[]{end, start});
			}
			end = i[1];
		}

		for(int[] i : list){
			System.out.print("["+i[0]+","+i[1]+"] ");
		}
	}

	// time taken O ( n * log(k) ) && space taken O ( k ) -> ( heap contains atmost k element at a time where (k < n) )

	void findFreeInterval2(int[][] interval){
		List<int[]> list = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

		for(int[] i : interval){
			pq.add(new int[]{i[0], i[1]});
		}

		int end = Integer.MAX_VALUE;
		while(!pq.isEmpty()){
			int[] curr = pq.poll();
			int start = curr[0];

			if(end < start){
				list.add(new int[]{end, start});
			}
			end = curr[1];
		}

		for(int[] i : list){
			System.out.print("["+i[0]+","+i[1]+"] ");
		}
	}
}

class EmployeeFreeTime{
	public static void main(String[] args) {
		int[][] interval = {
			{1,3},
			{2,4},
			{6,8},
			{9,12},
		};

		Sol sol = new Sol();
		sol.findFreeInterval2(interval);
		System.out.println();
		sol.findFreeInterval1(interval);
	}
}