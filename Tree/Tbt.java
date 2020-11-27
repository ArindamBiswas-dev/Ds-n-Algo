class Node{
	int data;
	Node right = left = null;
	boolean rightThread;
	boolean leftThread;

	Node(int data){
		this.data = data;
		right = left = null;
	}

}

class BinarySearchTree{
	Node insert(Node root,int data){
		if(root == null){
			Node n = new Node(data);
			n.rightThread = false;
		}
	}
}

class Tbt{
    public static void main (String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;
        root = bst.insert(root,10);
    }
}