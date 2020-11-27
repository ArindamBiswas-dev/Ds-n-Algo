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
	void rightViewOfABinaryTree(Node head){
		Queue<Node> q = new LinkedList<>();
		ArrayList<Integer> a = new ArrayList<>();
		q.add(head);

		while(q.peek() != null){
			int levelSize = q.size();

			for(int i=0; i<levelSize; i++){
				Node currentNode = q.poll();

				if(i == levelSize-1) a.add(currentNode.data);

				if(currentNode.left != null) q.add(currentNode.left);
				if(currentNode.right != null) q.add(currentNode.right);
			}
		}
		System.out.print(a);
	}
}

class RightViewOfABinaryTree{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		// head.left.right = new Node(5);
		// head.right.left = new Node(6);
		// head.right.right = new Node(7);

		Sol sol = new Sol();
		sol.rightViewOfABinaryTree(head);
	}
}