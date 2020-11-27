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
	void levelOrderSuccessor(Node head, int val){
		Queue<Node> q = new LinkedList<>();
		boolean flag = true;

		q.add(head);
		Node currentNode = null;

		while(q.peek() != null && flag){

			currentNode = q.poll();
			if(currentNode.data == val) flag = false;

			if(currentNode.left != null){
				q.add(currentNode.left);
			}
			if(currentNode.right != null){
				q.add(currentNode.right);
			}

		}
		System.out.print(q.peek().data);
	}
}

class LevelOrderSuccessor{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		// head.right.left = new Node(6);
		// head.right.right = new Node(7);

		int val = 3;
		Sol sol = new Sol();
		sol.levelOrderSuccessor(head, val);
	}
}