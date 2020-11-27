class Sol{
	int find(int[] a, int item){
		int start = 0;
		int end = 1; // 2^0
		int key = -1;
		int mid;

		while (start <= end) {

			if(item >= a[start] && item < a[end]){
				mid = start + (end - start)/2;
				if(a[mid] == item){
					return mid;
				}
				else if(a[mid] > item){
					end = mid - 1;
				}
				else{
					start = mid + 1;
				}
			}
			start = end + 1;
			end = (int)Math.pow(2, start);
		}
		return key;
	}
}

class SearchSortedInfiniteArray{
	public static void main(String[] args) {
		int[] a = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
		int item = 18;

		Sol sol = new Sol();
		System.out.print(sol.find(a, item));
	}
}