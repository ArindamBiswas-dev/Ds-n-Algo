import java.util.*;

class Node{
	int data;
	Node left;
	Node right;

	Node(int val){
		data = val;
		left = null;
		right = null;
	}
}

class Sol{
	int allPathsForASum(Node head, int targetSum, int sum){
		ArrayList<ArrayList<Integer>> mainList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currList = new ArrayList<Integer>();

		allPathsForASumUtil(head, targetSum, sum, mainList, currList);

		return mainList.size();
	}

	void allPathsForASumUtil(Node head, int targetSum, int sum, ArrayList<ArrayList<Integer>> mainList, ArrayList<Integer> currList){
		if(head == null){
			return;
		}

		currList.add(head.data);
		sum += head.data;

		if(head.left == null && head.right == null && sum == targetSum){
			mainList.add(currList);
		} else {
			allPathsForASumUtil(head.left, targetSum, sum, mainList, currList);
			allPathsForASumUtil(head.right, targetSum, sum, mainList, currList);
		}
		currList.remove(currList.size()-1);
	}
}

class AllPathsForASum{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(6);
		head.right.left = new Node(5);

		int targetSum = 7;

		Sol sol = new Sol();
		System.out.print(sol.allPathsForASum(head, targetSum, 0));
	}
}