class Sol{
	int findKey(int[] a, int length, int item){

		int start = 0;
		int end = length-1;

		boolean isAccending = false;

		if(a[start] > a[end]){
			isAccending = true;
		}
		
		int mid;

		while (start <= end) {
			// mid = (start + end)/2;       due to integer overflow problem
			mid = start + (end - start)/2;

			if(a[mid] == item) return mid;

			if(isAccending){
				if(a[mid] < item) start = mid + 1;
				else end = mid - 1;
			} else {
				if(a[mid] < item) end = mid - 1;
				else start = mid + 1;
			}
			
		}
		return -1;
	}
}

class OrderagnosticBinarySearch{
	public static void main(String[] args) {
		int[] a = {10,9,9,8,3};
		int length = a.length;
		int item = 9;

		Sol sol = new Sol();
		System.out.print(sol.findKey(a, length, item));
	}
}