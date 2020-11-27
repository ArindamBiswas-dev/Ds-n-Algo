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
	void zigzagTraversal(Node head){
		Queue<Node> q = new LinkedList<>();
		List<int[]> l = new ArrayList<>();
		// int count = 0;
		boolean leftToright = true;

		q.add(head);
		while(q.peek() != null){
			// ++count;
			int levelSize = q.size();
			int[] a = new int[levelSize];

			for(int i=0; i<levelSize; i++){
				Node currentNode = q.poll();

				if(leftToright){
					a[i] = currentNode.data;
				} else {
					a[levelSize-i-1] = currentNode.data;
				}

				if(currentNode.left != null){
					q.add(currentNode.left);
				}
				if(currentNode.right != null){
					q.add(currentNode.right);
				}
			}
			leftToright = !leftToright;
			l.add(a);
		}

		for(int[] i : l){
			for(Integer k : i){
				System.out.print(k);
			}
			System.out.println();
		}

	}
}

class ZigzagTraversal{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		Sol sol = new Sol();
		sol.zigzagTraversal(head);
	}
}