class Sol{
	int findMinDiff(int[] a, int length, int item){
		int start = 0;
		int end = length-1;
		int mid;
		int minDiff = Integer.MAX_VALUE;
		int key = a[start];

		while (start <= end) {
			mid = start + (end - start)/2;
			if(a[mid] == item){
				return item;
			}
			else if(a[mid] < item){
				start = mid + 1;
			}
			else{
				end = mid - 1;
			}
			if(Math.abs(item-a[mid]) <= minDiff){
				minDiff = Math.abs(item-a[mid]);
				key = a[mid];
			}
		}
		return key;
	}
}

class MinimumDifferenceElement{
	public static void main(String[] args) {
		int[] a = {1, 3, 5, 8, 10, 15};
		int length = a.length;
		int item = 13;

		Sol sol = new Sol();
		System.out.print(sol.findMinDiff(a, length, item));
	}
}