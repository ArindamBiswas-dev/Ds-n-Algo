import java.util.ArrayList;
import java.util.List;

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

    boolean Path(List<Integer> path, Node root, int data){
    	if(root == null){
    		return false;
    	}
    	path.add(root.data);
    	if(root.data == data){
    		return true;
    	}
    	if(root.left != null && Path(path,root.left,data)){
    		return true;
    	}
    	if(root.right != null && Path(path,root.right,data)){
    		return true;
    	}
    	path.remove(path.size()-1);
    	return false;
    }

    int lca(Node root, int a,int b){
    	List<Integer> path1 = new ArrayList<Integer>();
    	List<Integer> path2 = new ArrayList<Integer>();
    	Path(path1,root,a);
    	Path(path2,root,b);
    	int l = -1;
    	for(int i=0; i<path1.size() && i< path2.size(); i++){
    		if(path1.get(i) == path2.get(i)){
    			l = path1.get(i);
    		}
    	}
    	return l;
    }
 }

    class Main{
    public static void main (String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;
        root  = bst.insertNode(root,25);
        bst.insertNode(root,55);
        bst.insertNode(root,15);
        bst.insertNode(root,45);
        bst.insertNode(root,5);
        bst.insertNode(root,14);
        bst.insertNode(root,75);
        System.out.print(bst.lca(root,45,75));
    }
}

//            25
//        15        55
//      5       45
//	  1   16