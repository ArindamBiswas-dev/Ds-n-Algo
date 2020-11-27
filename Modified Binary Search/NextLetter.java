class Sol{
	char findLetter(char[] a, char item, int length){
		int start = 0;
		int end = length-1;
		if(a[end] < item) return a[0];
		int mid;
		int minDiff = Integer.MAX_VALUE;
		char key = 'z';

		while (start <= end) {
			mid = start + (end - start)/2;

			if(a[mid] == item){
				return item;
			} else if(a[mid] < item){
				start = mid + 1;
			} else {
				if(minDiff > a[mid]-item){
					minDiff = a[mid];
					key = a[mid];
				}
				end = mid - 1;
			}
		}
		return key;
	}
}

class NextLetter{
	public static void main(String[] args) {
		char[] a = {'a', 'c', 'f', 'h'};
		char item = 'g';
		int length = a.length;

		Sol sol = new Sol();
		System.out.print(sol.findLetter(a, item, length));
	}
}