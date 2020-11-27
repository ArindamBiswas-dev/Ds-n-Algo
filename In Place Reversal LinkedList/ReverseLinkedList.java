import java.util.*;

class Node{
	int data;
	Node next;
	Node(int val){
		data = val;
		next = null;
	}
}

class Sol{
	Node reverse(Node head){
		Node temp = head;
		Node prev = null;

		while (temp != null) {
			Node curr = temp;
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			temp = next;
		}
		head = prev;
		return head;
	}
}

class ReverseLinkedList{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		Sol sol = new Sol();
		head = sol.reverse(head);
		System.out.print(head.data);
		System.out.print(head.next.data);
		System.out.print(head.next.next.data);
		System.out.print(head.next.next.next.data);
	}
}