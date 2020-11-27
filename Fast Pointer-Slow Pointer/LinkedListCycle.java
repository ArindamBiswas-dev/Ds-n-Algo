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
	boolean detectCycle(Node head){
		Node first = head;
		Node second = head;
		while(first != null && second != null){
			first = first.next.next;
			second = second.next;
			if(first == second){
				return true;
			}
		}
		return false;
	}
}

class LinkedListCycle{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		// creating a loop in the linkedlist 6 -> 3
		head.next.next.next.next.next.next = head.next.next;

		Sol sol = new Sol();
		System.out.print(sol.detectCycle(head));
	}
}