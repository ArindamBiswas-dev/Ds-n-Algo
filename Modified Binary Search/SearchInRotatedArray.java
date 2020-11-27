class Sol{
	int find(int[] a, int length, int item){
		int start = 0;
		int end = length - 1;
		int mid;

		while (start <= end) {
			mid = start + (end - start)/2;
			if(a[mid] == item){
				return mid;
			}
			else if(a[start] < a[mid]){
				if(item >= a[start] && item < a[mid]){
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			else{
				if(item > a[mid] && item <= a[end]){
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}
}

class SearchInRotatedArray{
	public static void main(String[] args) {
		int[] a = {14, 15, 16, 9, 10, 11, 12};
		int length = a.length;
		int item = 10;

		Sol sol = new Sol();
		System.out.print(sol.find(a, length, item));
	}
}