package src.com.pack.tree;

public class IsBST {

	Node root;
	
	IsBST(){
		root = null;
	}
	
	public static void main(String[] args) {
	
		IsBST tree2 = new IsBST();
		// To check Given tree is BST
		
		tree2.root = new Node(4); 
		tree2.root.left = new Node(2); 
		tree2.root.right = new Node(5); 
		tree2.root.left.left = new Node(1); 
		tree2.root.left.right = new Node(13);
		

		boolean flag = tree2.isBSTUtil(tree2.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("is Given Tree BST =>"+flag);
		
	}	
	
	private boolean isBSTUtil(Node root, int minValue, int maxValue) {
		
		if(root==null) {
			return true;
		}
		if(root.key < minValue || root.key > maxValue) return false;
				
		return (isBSTUtil(root.left, minValue, root.key) && isBSTUtil(root.right, root.key, maxValue)); 
		
	}
	
	
	/*
	 * private Node insert(Node root,int newNode) {
	 * 
	 * if(root == null) { root = new Node(newNode); return root; }
	 * 
	 * if (root.key > newNode) { root.left = insert(root.left,newNode); } else {
	 * root.right = insert(root.right,newNode); } return root; }
	 */

}
