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
	int sumOfPathNumbers(Node head, int sum){ // ArrayList<Integer> a, 
		if(head == null){
			return 0;
		}

		sum = sum * 10 + head.data;
		if(head.left == null && head.right == null){
			// a.add(sum);
			return sum;
		}

		int lSum = sumOfPathNumbers(head.left, sum); // a
		int rSum = sumOfPathNumbers(head.right, sum); // a
		return lSum + rSum;
	}
}

class SumOfPathNumbers{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(6);
		head.right.left = new Node(5);

		int targetSum = 9;
		// ArrayList<Integer> a = new ArrayList<>();
		int sum = 0;

		Sol sol = new Sol();
		System.out.print(sol.sumOfPathNumbers(head, sum)); // a, 
		// System.out.print(a);
	}
}