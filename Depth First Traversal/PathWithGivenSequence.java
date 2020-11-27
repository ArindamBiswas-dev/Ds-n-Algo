import java.util.*;

class Node{
	int data;
	Node left;
	Node right;

	Node(int val){
		data = val;
		left = null;
		right = null;
	}
}

class Sol{
	boolean pathWithGivenSequence(Node head, int[] seq, int count, int length){
		
		if(head.data != seq[count]){
			return false;
		}
		if(head.left == null && head.right == null && count == length-1){
			return true;
		}
		boolean lPath = pathWithGivenSequence(head.left, seq, count+1, length);
		boolean rPath = pathWithGivenSequence(head.right, seq, count+1, length);
		if (lPath == true || rPath == true) return true;
		return false;
	}
}

class PathWithGivenSequence{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(6);
		head.right.right = new Node(5);

		int[] seq = {1,3,5};

		Sol sol = new Sol();
		System.out.print(sol.pathWithGivenSequence(head, seq, 0, seq.length));
	}
}