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
	boolean binaryTreePathSum(Node head, int sum, int targetSum){
		if(head == null){
			// System.out.println(sum+" "+targetSum);
			return (sum == targetSum) ? true : false;
		}

		sum += head.data;
		// System.out.println(sum+" s "+head.data);
		boolean r1 = binaryTreePathSum(head.left, sum, targetSum);
		boolean r2 = binaryTreePathSum(head.right, sum, targetSum);
		if(r1 == true || r2 == true)
			return true;
		else{
			sum -= head.data;
			return false;
		}
	}
}

class BinaryTreePathSum{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(6);
		head.right.left = new Node(5);

		int targetSum = 9;

		Sol sol = new Sol();
		System.out.print(sol.binaryTreePathSum(head,0,targetSum));
	}
}