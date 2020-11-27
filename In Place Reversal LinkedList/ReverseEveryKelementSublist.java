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
	Node reverseEveryKelementSublist(Node head, int k, int length){
		if(k <= 1) return head;

		Node current = head;
		Node previous = null;

		while(current != null){

			Node lastNodeofPrePart = previous;
			Node lastNodeofCurrPart = current;
			Node next = null;

			for(int i=0; i<k && current != null; i++){
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			if(lastNodeofPrePart != null){
				lastNodeofPrePart.next = previous;
			} else {
				head = previous;
			}

			lastNodeofCurrPart.next = current;
			previous = lastNodeofCurrPart;

		}
		return head;
	}
}

class ReverseEveryKelementSublist{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		int k = 2;

		Sol sol = new Sol();
		head = sol.reverseEveryKelementSublist(head,k,4);
		System.out.print(head.data);
		System.out.print(head.next.data);
		System.out.print(head.next.next.data);
		System.out.print(head.next.next.next.data);
		System.out.print(head.next.next.next.next.data);
	}
}