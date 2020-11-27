import java.util.*;

class kSorted{
	static void ksort(int[] a,int k){
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int[] arr = new int[a.length];
		int j = 0;
		for(int i=0;i<a.length;i++){
			if(minHeap.size() < k){
				minHeap.add(a[i]);
			}
			else{
				minHeap.add(a[i]);
				arr[j++] = minHeap.poll();
			}
		}
		while(minHeap.size() > 0){
			arr[j++] = minHeap.poll();
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}

}

class heapMain{
	public static void main(String[] args) {
		int[] a =  {6, 5, 7, 8, 9};
		int k = 3;
		int x = 7;
		kSorted.ksort(a,k);
	}
}