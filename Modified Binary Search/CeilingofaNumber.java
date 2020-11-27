class Sol{
	int findKey(int[] a, int length, int item){
		int start = 0;
		int end = length-1;
		int mid;
		int minDiff = Integer.MAX_VALUE;
		int key = -1;

		while (start <= end) {
			mid = start + (end-start)/2;

			if(a[mid] == item){
				return mid;
			}
			else if(a[mid] < item){
				start = mid + 1;
			}
			else {
				if(minDiff > a[mid]-item){
					minDiff = a[mid]-item;
					key = mid;
				}
				end = mid-1;
			}
		}
		return key;
	}
}

class CeilingofaNumber{
	public static void main(String[] args) {
		int[] a = {1,3,4,8,10};
		int length = a.length;
		int item = 5;

		Sol sol = new Sol();
		System.out.println(sol.findKey(a, length, item));
		System.out.print('b' - 'a');
	}
}