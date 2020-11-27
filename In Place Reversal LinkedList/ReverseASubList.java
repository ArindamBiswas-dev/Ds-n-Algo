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
	Node reverseSubList(Node head, int p, int q){
		if(p == q){
			return head;
		}

		int count = q-p+1;

		Node previous = null;
		Node temp = head;
		while (temp != null && p > 1) {
			previous = temp;
			temp = temp.next;
			p--;
		}

		Node lastNodeofFirstPart = previous;
		Node lastNodeofSubList = temp;
		Node prev = null;

		while (temp != null && count > 0) {
			Node curr = temp;
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			temp = next;
			count--;
		}

		if(lastNodeofFirstPart != null){
			lastNodeofFirstPart.next = prev;
		} else {
			head = prev;
		}

		lastNodeofSubList.next = temp;
		return head;
	}
}

class ReverseASubList{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		int p = 1;
		int q = 4;

		Sol sol = new Sol();
		head = sol.reverseSubList(head,p,q);
		System.out.print(head.data);
		System.out.print(head.next.data);
		System.out.print(head.next.next.data);
		System.out.print(head.next.next.next.data);

	}
}