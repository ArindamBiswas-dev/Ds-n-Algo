import java.util.*;

class pairNode implements Comparable<pairNode> {
	int value;
	int key;
	pairNode(int value,int key){
		this.value = value;
		this.key = key;
	}
	   @Override
    public int compareTo(pairNode o) {
        return o.value > this.value ? 1 : -1;		//  this line is reqired because, PriorityQueue does not know how to and what to compare of " pairNode "
    }												//  obj. value, because its required when after adding / polling an element PQ go to heapify the queue.
}

// class pairNode implements Comparator<pairNode>{ 
//     int value;
// 	int key;
// 	pairNode(int value,int key){
// 		this.value = value;
// 		this.key = key;
// 	}
//             // Overriding compare()method of Comparator  
//                         // for descending order of cgpa 
//            public int compare(pairNode s1, pairNode s2) { 
//                 if (s1.value > s2.value) 
//                     return 1; 
//                 else if (s1.value < s2.value) 
//                     return -1; 
//                 return 0; 
//                 } 
//         } 

class Kvalue{
	Queue<pairNode> pq = new PriorityQueue<>();


	void Kclosest(int[] a, int k, int x){

		for(int i=0;i<k;i++){

			int value = Math.abs(a[i]-x);
			int key = a[i];
			pq.add(new pairNode(value,key));

		}

		for(int i=k;i<a.length;i++){

			int value = Math.abs(a[i]-x);
			int key = a[i];
			if(pq.peek().value > value){
				pq.poll();
				pq.add(new pairNode(value,key));
			}

		}
		while(pq.size() > 0){
			int res = pq.peek().key;
			int count = 0;
			pq.poll();
			System.out.println(res);
		}

	}
}



class test3{
	public static void main(String[] args) {
		int[] a =  {6, 5, 7, 8, 9};
		int k = 3;
		int x = 7;

		Kvalue pq = new Kvalue();
		pq.Kclosest(a,k,x);
	}
}