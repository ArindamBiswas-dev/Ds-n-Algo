import java.util.*;

class Sol{
	void findSubsets(int[] a, int length){
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<ArrayList<Integer>>();
		mainList.add(new ArrayList<Integer>());

		for(Integer currNum : a){

			int len = mainList.size();

			for(int i=0; i<len; i++){
				ArrayList<Integer> list = new ArrayList<Integer>(mainList.get(i));
				list.add(currNum);
				mainList.add(list);
			}
		}

		System.out.print(mainList);
	}
}

class FindSubsets{
	public static void main(String[] args) {
		int[] a = {1,3,6};
		int length = a.length;

		Sol sol = new Sol();
		sol.findSubsets(a, length);
	}
}