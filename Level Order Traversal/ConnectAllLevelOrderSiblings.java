import java.util.*;

class Node{
	int data;
	Node left;
	Node right;
	Node next;

	Node(int val){
		data = val;
		left = null;
		right = null;
		next = null;
	}
}

class Sol{
	void connectAllLevelOrderSiblings(Node head){
		Queue<Node> q = new LinkedList<>();
		q.add(head);
		Node previousNode = null;

		while(q.peek() != null){
			int levelSize = q.size();

			for(int i=0; i<levelSize; i++){
				Node currentNode = q.poll();
				if(previousNode != null) previousNode.next = currentNode;
				if(currentNode.left != null) q.add(currentNode.left);
				if(currentNode.right != null) q.add(currentNode.right);
				previousNode = currentNode;
			}
		}

		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
}

class ConnectAllLevelOrderSiblings{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		Sol sol = new Sol();
		sol.connectAllLevelOrderSiblings(head);
	}
}