package src.com.pack.tree;

public class MinAndMaxNode {

	Node root;
	
	MinAndMaxNode(){
		root = null;
	}
	
	public static void main(String[] args) {	
		
		MinAndMaxNode tree = new MinAndMaxNode();
		tree.root = tree.insert(tree.root,50); 
		tree.root = tree.insert(tree.root,30); 
		tree.root = tree.insert(tree.root,20); 
		tree.root = tree.insert(tree.root,40); 
	//	tree.root = tree.insert(tree.root,35);
		tree.root = tree.insert(tree.root,70); 
		tree.root = tree.insert(tree.root,60); 
		tree.root = tree.insert(tree.root,80);

		Node minNode = tree.findMin(tree.root);
		System.out.println();
		System.out.println("Min Element in the Tree :"+minNode.key);
		
		
		Node maxNode = tree.findMax(tree.root);
		System.out.println("Min Element in the Tree :"+maxNode.key);
		
	}	
	
	private Node findMax(Node root) {
		
		if(root.right ==null) {
			return root;
		}
		
		return findMax(root.right);
	}

	
	private Node findMin(Node root) {
		
		if(root.left ==null) {
			return root;
		}
		return findMin(root.left);
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
