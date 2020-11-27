class Sol{
	int[] findRange(int[] a, int length, int item){
		int[] result = {-1, -1};

		result[0] = findRangeUtil(a, length, item, true);
		result[1] = findRangeUtil(a, length, item, false);

		return result;
	}

	int findRangeUtil(int[] a, int length, int item, boolean isFirstfind){

		int start = 0;
		int end = length-1;
		int mid;
		int key = -1;

		while (start <= end) {

			mid = start + (end-start)/2;

			if(a[mid] == item){
				
				key = mid;

				if(isFirstfind)
				 	end = mid - 1;
				else 
					start = mid + 1;
			}

			else if(a[mid] < item) start = mid + 1;

			else end = mid - 1;
		}
		return key;
	}
}

class NumberRange{
	public static void main(String[] args) {
		int[] a = {4, 6, 6, 6, 9};
		int length = a.length;
		int item = 6;

		Sol sol = new Sol();
		int[] result = sol.findRange(a, length, item);
		System.out.print("["+result[0]+","+result[1]+"]");
	}
}