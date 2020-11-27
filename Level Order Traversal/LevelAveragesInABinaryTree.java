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
	void levelAveragesInABinaryTree(Node head){
		Queue<Node> q = new LinkedList<>();
		ArrayList<Double> l = new ArrayList<>();
		int sum = 0;

		q.add(head);
		while (q.peek() != null) {
			int levelSize = q.size();
			for(int i=0; i<levelSize; i++){
				Node currentNode = q.poll();
				sum += currentNode.data;
				if(currentNode.left != null) q.add(currentNode.left);
				if(currentNode.right != null) q.add(currentNode.right);
			}
			l.add((double)sum/levelSize);
			sum = 0;
		}
		System.out.print(l);
	}
}

class LevelAveragesInABinaryTree{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		Sol sol = new Sol();
		sol.levelAveragesInABinaryTree(head);
	}
}