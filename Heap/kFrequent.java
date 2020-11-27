import java.util.*;

class kFre{
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	PriorityQueue<Integer> minHeap = new PriorityQueue<>((a1, a2) -> (map.get(a2) - map.get(a1)));


	void Kfrequent(int[] a, int k){
		for(int i=0;i<a.length;i++){
			map.put(a[i],map.getOrDefault(a[i], 0)+1);
		}
		
		for(int num : map.keySet()){
			minHeap.add(num);
		}

		for(int i=0;i<a.length;){
			int key = minHeap.peek();
			for(int j=0;j<map.get(key);j++){
				System.out.print(key);
			}
			System.out.print(" ");
			minHeap.poll();
			i += map.get(key);
		}
	}
}


class kFrequent{
	public static void main(String[] args) {
		int[] a =  {2, 5, 2, 8, 5, 6, 8, 8};			// 1, 2, 3, 4
		int k = 3; 										// 1, 2, 4
		kFre pq = new kFre();
		pq.Kfrequent(a,k);
	}
}