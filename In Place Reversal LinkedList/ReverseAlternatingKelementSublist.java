class Node{
	int data;
	Node next;
	Node(int val){
		data = val;
		next = null;
	}
}

class Sol{
	Node reverseAltSubList(Node head, int k){
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

			// System.out.println(previous.data+"p");
			// if(current != null) System.out.println(current.data+"c");

			for(int i=0; i<k && current != null; i++){
				// System.out.println(previous.data+"p");
				// System.out.println(current.data+"c");
				previous = current;
				current = current.next;		
			}
				//	 2	1	3	4	6	5	

		}
		return head;
	}
}

class ReverseAlternatingKelementSublist{
	public static void main(String[] args) {
		Node head;
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		int k = 2;

		Sol sol = new Sol();
		head = sol.reverseAltSubList(head,k);
		System.out.print(head.data);
		System.out.print(head.next.data);
		System.out.print(head.next.next.data);
		System.out.print(head.next.next.next.data);
		System.out.print(head.next.next.next.next.data);
		System.out.print(head.next.next.next.next.next.data);
	}
}