class Sol{
	int countRotation(int[] a, int length){
		int start = 0;
		int end = length-1;
		int mid;

		while (start <= end) {
			mid = start + (end-start)/2;
			if(a[mid] < a[start]){
				if(a[mid-1] >= a[mid]){
					start = mid - 1;
				}
			}
		}
	}
}

class RotationCount{
	public static void main(String[] args) {
		int[] a = {4, 5, 7, 9, 10, -1, 2};
		int length = a.length;

		Sol sol = new Sol();
		System.out.print(sol.countRotation(a, length));
	}
}