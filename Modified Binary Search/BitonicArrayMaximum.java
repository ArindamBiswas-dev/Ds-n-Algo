class Sol{
	int findMax(int[] a, int length){
		int start = 0;
		int end = length-1;
		int mid;
		int max = Integer.MIN_VALUE;

		while (start <= end) {
			mid = start + (end-start)/2;

			if(a[mid] > max){
				max = a[mid];
			}

			if(start != end && a[mid] > a[mid+1]){
				end = mid-1;
			}
			else{
				start = mid + 1;
			}
		}
		return max;
	}
}

class BitonicArrayMaximum{
	public static void main(String[] args) {
		int[] a = {10, 9, 8};
		int length = a.length;

		Sol sol = new Sol();
		System.out.print(sol.findMax(a, length));
	}
}