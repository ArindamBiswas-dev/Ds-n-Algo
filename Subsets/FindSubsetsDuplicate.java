import java.util.*;

class Sol{
	void findSubsetsDuplicate(int[] a, int length){
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<ArrayList<Integer>>();
		mainList.add(new ArrayList<Integer>());
		Arrays.sort(a);
		int startIndex = 0;
		int endIndex = 0;

		for(int i=0; i<length; i++){
			startIndex = 0;

			if(i > 0 && a[i] == a[i-1]){
				startIndex = endIndex+1;
			}
			System.out.println(startIndex);

			endIndex = mainList.size()-1;

			for(int j=startIndex; j<=endIndex; j++){
				ArrayList<Integer> list = new ArrayList<Integer>(mainList.get(j));
				list.add(a[i]);
				mainList.add(list);
			}

		}

		System.out.print(mainList);				// [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
	}
}

class FindSubsetsDuplicate{
	public static void main(String[] args) {
		int[] a = {1,5,3,3};
		int length = a.length;

		Sol sol = new Sol();
		sol.findSubsetsDuplicate(a, length);
	}
}