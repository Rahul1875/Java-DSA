package src.com.pack.tree;

class Node{
	
	int key;
	Node left,right;
	Node(int node){
		key = node;
		left = right = null;
	}
}


public class BinarySearchTreeImp {

	Node root;
	BinarySearchTreeImp(){
		root = null;
	}
	
	public static void main(String[] args) {
	
		BinarySearchTreeImp tree = new BinarySearchTreeImp();
		tree.root = tree.insert(tree.root,50); 
		tree.root = tree.insert(tree.root,30); 
		tree.root = tree.insert(tree.root,20); 
		tree.root = tree.insert(tree.root,40); 
	//	tree.root = tree.insert(tree.root,35);
		tree.root = tree.insert(tree.root,70); 
		tree.root = tree.insert(tree.root,60); 
		tree.root = tree.insert(tree.root,80);
		
		System.out.println("Inorder Traversal of the Tree");
		tree.traverse(tree.root);
		
	}	
	
	private void traverse(Node root) {
		if(root!=null) {
			traverse(root.left);
			System.out.print(root.key+"->");
			traverse(root.right);
		}
		
	}

	
	private Node insert(Node root,int newNode) {
		
		if(root == null) {
			root = new Node(newNode);
			return root;
		}
		
		if (root.key > newNode) {
			root.left = insert(root.left,newNode);
		} else {
			root.right = insert(root.right,newNode);
		}
		return root;
	}
	
}
