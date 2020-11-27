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
	boolean isPalindrome(Node head){
		Node fastPointer = head;
		Node lastPointer = head;
		while(fastPointer != null && fastPointer.next != null){
			fastPointer = fastPointer.next.next;
			lastPointer = lastPointer.next;
		}

		Node headSecondHalf = reversedLinkedList(lastPointer);
		Node cpyHeadSecondHalf = headSecondHalf;

		while(head != null && headSecondHalf != null){
			if(head.data != headSecondHalf.data){
				reversedLinkedList(headSecondHalf);
				return false;
			}
			head = head.next;
			headSecondHalf = headSecondHalf.next;
		}

		reversedLinkedList(cpyHeadSecondHalf);
		return true;
	}

	Node reversedLinkedList(Node head){
		Node current, prev, next;
		current = head;
		prev = null;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
}

class PalindromeLinkedList{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(5);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(1);

		Sol sol = new Sol();
		System.out.print(sol.isPalindrome(head));
	}
}