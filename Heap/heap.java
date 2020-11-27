
class heapOp{
	int size = 0;
	void insert(int value, int[] a){
		a[size] = value;
		int index = size;
		int parent = (index-1)/2;

		while(parent >= 0 && a[parent] < a[index]){
			int temp = value;
			a[index] = a[parent];
			a[parent] = temp;

			index = parent;
			parent = (index-1)/2;
		}
		size++;
	}
	void removeMax(int[] a){
		a[0] = a[size-1];
		int index = size-1;
		maxHeapfy(a,0);
	}
	// place the array into maxHeap order
	void maxHeapfy(int[] a,int index){
		int l = index*2+1;
		int r = index*2+2;
		int largest = index;
		if(a[l] > a[index]){
			largest = l;
		}
		if(a[r] > a[index]){
			largest = r;
		}
		if(largest != index){
			int temp = a[index];
			a[index] = a[largest];
			a[largest] = temp;

			maxHeapfy(a,largest);
		}
	}
}

class heap{
	public static void main(String[] args) {
		int[] a = new int[15];
		heapOp hop = new heapOp();
		hop.insert(22,a);
		hop.insert(10,a);
		hop.insert(29,a);
		hop.insert(39,a);
		hop.insert(49,a);
		hop.removeMax(a);
		for(int i=0;i<4;i++){
			System.out.print(a[i]+" ");
		}
		
	}
}