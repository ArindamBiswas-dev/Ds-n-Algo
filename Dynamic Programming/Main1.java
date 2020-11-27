class Node{
    int data;
    Node right;
    Node left;
    
    Node(int value){
        data = value;
        left = null;
        right = null;
    }
}

class BinarySearchTree{
 
    Node insertNode(Node root,int data){
        if(root == null){
            root = new Node(data);
        }
        else if(root.data > data){
            root.left = insertNode(root.left,data);
        }
        else{
            root.right = insertNode(root.right,data);
        }
        return root;
    }


}

class Main1{
    public static void main (String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;
        root  = bst.insertNode(root,25);
        bst.insertNode(root,55);
        bst.insertNode(root,15);
        bst.insertNode(root,45);
        bst.insertNode(root,5);
        bst.insertNode(root,1);
        // bst.postOrder(root,-1);
        // System.out.print(root.data);
    }
}

//            25
//        15        55
//      5       45