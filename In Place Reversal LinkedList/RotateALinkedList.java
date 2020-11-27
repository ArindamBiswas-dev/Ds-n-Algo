class Node{
	int data;
	Node next;
	Node(int val){
		data = val;
		next = null;
	}
}

class Sol{
	Node rotateList(Node head, int k){
		Node temp = head;
		Node lastNode = head;
		while(lastNode.next != null) {
			lastNode = lastNode.next;
		}

		while(k > 1){
			 lastNode.next = temp;
			 lastNode = lastNode.next;
			 temp = temp.next;                   
			 k--;
		}

		head = temp.next;
		temp.next = null;
		return head;
	}
}

class RotateALinkedList{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		int k = 3;

		Sol sol = new Sol();
		head = sol.rotateList(head,k);
		System.out.print(head.data);
		System.out.print(head.next.data);
		System.out.print(head.next.next.data);
		System.out.print(head.next.next.next.data);
		System.out.print(head.next.next.next.next.data);
		System.out.print(head.next.next.next.next.next.data);
	}
}