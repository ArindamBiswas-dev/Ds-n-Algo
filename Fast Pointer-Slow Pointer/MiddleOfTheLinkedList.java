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
	int findMiddle(Node head){
		Node fastPointer = head;
		Node slowPointer = head;

		while(fastPointer.next != null){
			if(fastPointer.next.next != null)
				fastPointer = fastPointer.next.next;
			else
				fastPointer = fastPointer.next;
			
			slowPointer = slowPointer.next;
		}
		return slowPointer.data;
	}
}

class MiddleOfTheLinkedList{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		Sol sol = new Sol();
		System.out.print(sol.findMiddle(head));
	}
}