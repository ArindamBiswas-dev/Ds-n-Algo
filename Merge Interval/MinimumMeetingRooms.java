import java.util.*;

class Sol{
	int isConflict(int[][] interval){
		Arrays.sort(interval, (a,b) -> a[0]-b[0]);

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

		int end = Integer.MIN_VALUE;
		int start = Integer.MAX_VALUE;
		int count = 0;
		int minHeapLength = 0;

		for(int[] i : interval){
			start = i[0];
			end = i[1];
			while (minHeap.peek() != null && minHeap.peek() <= start){
				minHeap.poll();			
			}

			int c = 0;
			minHeap.offer(end);
			
			for(Integer k : minHeap){
				c++;
			}

			count = Math.max(count, c);
		}

		return count;
	}
}

class MinimumMeetingRooms{
	public static void main(String[] args) {
		int[][] interval = {
			{4,5},
			{2,3},
			{2,4},
			{3,5},
		};

		Sol sol = new Sol();
		System.out.println(sol.isConflict(interval));
		// sol.totalConflict(interval);
	}
}