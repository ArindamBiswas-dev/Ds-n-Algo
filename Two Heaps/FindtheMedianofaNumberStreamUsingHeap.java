import java.util.*;

class Sol{
	void findMedian(int[] a, int length){
		PriorityQueue<Integer> heigher = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> lower = new PriorityQueue<>();

		for(int i=0; i<length; i++){
			addNumber(a[i], heigher, lower);
			balenceHeap(heigher, lower);
			calMedian(heigher, lower);
		}
	}

	void addNumber(int number, PriorityQueue<Integer> heigher, PriorityQueue<Integer> lower){
		if(heigher.size() == 0 || number < heigher.peek()){
			heigher.add(number);
		} else {
			lower.add(number);
		}
	}

	void balenceHeap(PriorityQueue<Integer> heigher, PriorityQueue<Integer> lower){
		PriorityQueue<Integer> bigger = (heigher.size() > lower.size()) ? heigher : lower;
		PriorityQueue<Integer> smaller = (heigher.size() < lower.size()) ? heigher : lower;

		smaller.add(bigger.poll());
	}

	void calMedian(PriorityQueue<Integer> heigher, PriorityQueue<Integer> lower){
		double median;

		if(heigher.size() == lower.size()){
			median = ((double)heigher.peek() + lower.peek())/2;
		} else {
			median = (heigher.size() > lower.size()) ? heigher.peek() : lower.peek();
		}
		System.out.println(median);
	}
}

class FindtheMedianofaNumberStreamUsingHeap{
	public static void main(String[] args) {
		int[] a = {3,1,4,5};
		int length = a.length;

		Sol sol = new Sol();
		sol.findMedian(a, length);
	}
}