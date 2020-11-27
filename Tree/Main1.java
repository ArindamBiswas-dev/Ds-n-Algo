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


    Node deleteNode(Node root,int data){
        if(root == null){
            return root;
        }
        else if(root.data > data){
            return root.left = deleteNode(root.left,data);
        }
        else if(root.data < data){
            return root.right = deleteNode(root.right,data);
        }
        else{
            if(root.left == null && root.right == null){
                root = null;
                return root;
            }
            else if(root.left == null){
                Node temp = root;
                root = root.right;
                temp = null;
                return root;
            }
            else if(root.right == null){
                Node temp = root;
                root = root.left;
                temp = null;
                return root;
            }
            else{
                Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.left,temp.data);
                return root;
            }
        }
    }
    Node findMin(Node r){
        if(r.left == null){
            return r;
        }
        return r = findMin(r.left);
    }

    Node Find(Node root,int data){
        if(root == null){
            return root;
        }
        if(root.data > data){
            root = root.left;
            return Find(root,data);
        }
        else if(root.data < data){
            root = root.right;
            return Find(root,data);
        }

        return root;
    }

    Node findMinRight(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    Node inOrderSuccessor(Node root,int data){
        Node current = Find(root,data);
        Node anccesstor = root;
        Node successor = null;
        if(root == null){
            return root;
        }
        if(current.right != null){
            successor = findMinRight(root.right);
            return successor;
        }

        while(anccesstor != current){
            if(anccesstor.data > current.data){
                successor = anccesstor;
                anccesstor = anccesstor.left;
            }
            else{
                anccesstor = anccesstor.right;
            }
        }
        return successor;
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
        bst.insertNode(root,16);
        // bst.postOrder(root,-1);
        // System.out.print(root.data);
        // bst.deleteNode(root,25);
        System.out.print(bst.inOrderSuccessor(root,5).data);
    }
}

//            25
//        15        55
//      5       45