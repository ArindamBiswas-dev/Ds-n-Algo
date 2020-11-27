import java.util.*;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		next = null;
	}
}

class Sol{
	void rearrange(Node head){
		Node middle;
		middle = findMiddle(head);
		// System.out.print(middle.data+" middle ");

		Node reverseMiddleHead;
		reverseMiddleHead = reverseMiddle(middle);
		// System.out.print(reverseMiddleHead.data+" reverse-middle ");

		Node firstPointer = head;
		Node secondPointer = reverseMiddleHead;
		Node next;
		while (firstPointer != null && secondPointer != null) {
			next = secondPointer.next;
			secondPointer.next = firstPointer.next;
			firstPointer.next = secondPointer;
			firstPointer = secondPointer.next;
			secondPointer = next;
		}
		firstPointer.next = null;
		// System.out.print(firstPointer.data+" f");
		// System.out.print(secondPointer.data+" s");
	}

	Node findMiddle(Node head){
		Node fastPointer = head;
		Node slowPointer = head;

		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		return slowPointer;
	}

	Node reverseMiddle(Node head){
		Node current, prev, next;
		current = head;
		prev = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
}

class RearrangeALinkedList{
	public static void main(String[] args) {
		Node head;
		head = new Node(2);
		head.next = new Node(4);
		head.next.next = new Node(6);
		head.next.next.next = new Node(8);
		head.next.next.next.next = new Node(10);
		// head.next.next.next.next.next = new Node(6);

		Node temp = head;
		int count = 0;
		Sol sol = new Sol();
		sol.rearrange(head);
		
		while (temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;	
		}
	}
}