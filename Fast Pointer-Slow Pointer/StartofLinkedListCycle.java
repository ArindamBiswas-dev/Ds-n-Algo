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
	int detectCycle(Node head){
		Node first = head;
		Node second = head;
		while(first != null && second != null){
			first = first.next.next;
			second = second.next;
			if(first == second){
				break;
			}
		}
		int cycleLength = calculateCycleLength(second.next,second);
		Node pointer1 = head;
		Node pointer2 = head;
		while(cycleLength > 0){
			pointer1 = pointer1.next;
			cycleLength--;
		}
		while(pointer1 != pointer2){
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer1.data;
	}

	int calculateCycleLength(Node curr, Node second){
		int count = 1;
		while(curr != second){
			curr = curr.next;
			count++;
		}
		return count;
	}

}

class StartofLinkedListCycle{
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