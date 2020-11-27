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
	int countPathsForASum(Node head, Queue<Integer> a, int count, int targetSum, int sum){
		if(head == null){
			return 0;
		}

		sum += head.data;
		a.add(head.data);

		while(sum > targetSum){
			sum -= a.poll();
		}
		if(sum == targetSum){
			++count;
		}

		int count1 = countPathsForASum(head.left, a, 0, targetSum, sum);
		int count2 = countPathsForASum(head.right, a, 0, targetSum, sum);
		return count + count1 + count2;
	}
}

class CountPathsForASum{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(6);
		head.right.right = new Node(5);
		head.left.left.left = new Node(4);

		Queue<Integer> a = new LinkedList<>();
		int targetSum = 9;

		Sol sol = new Sol();
		System.out.print(sol.countPathsForASum(head, a, 0, targetSum, 0));
	}
}