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
	void maximumDepthOfABinaryTree(Node head){
		Queue<Node> q = new LinkedList<>();
		int maxDepth = 0;
		boolean flag = true;

		q.add(head);
		Node currentNode = null;

		while(q.peek() != null && flag){
			int levelSize = q.size();
			++maxDepth;

			for(int i=0; i<levelSize; i++){
				currentNode = q.poll();
				if(currentNode.left != null){
					q.add(currentNode.left);
				}
				if(currentNode.right != null){
					q.add(currentNode.right);
				}
			}
		}
		System.out.println(currentNode.data);
		System.out.print(maxDepth);
	}
}

class MaximumDepthOfABinaryTree{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		// head.right.left = new Node(6);
		// head.right.right = new Node(7);

		Sol sol = new Sol();
		sol.maximumDepthOfABinaryTree(head);
	}
}