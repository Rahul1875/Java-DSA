package src.com.pack.tree;

public class BSTTreeHeight {

	Node root;
	
	BSTTreeHeight(){
		root = null;
	}
	
	public static void main(String[] args) {
	
		// Height = no of max edges in the path
		
		BSTTreeHeight tree = new BSTTreeHeight();
		tree.root = tree.insert(tree.root,50); 
		tree.root = tree.insert(tree.root,30); 
		tree.root = tree.insert(tree.root,20); 
		tree.root = tree.insert(tree.root,40); 
	//	tree.root = tree.insert(tree.root,35);
		tree.root = tree.insert(tree.root,70); 
		tree.root = tree.insert(tree.root,60); 
		tree.root = tree.insert(tree.root,80);

		int height = tree.findHeight(tree.root);
		System.out.println("Height of the Tree :"+height);
		
	}	
	
	private int findHeight(Node root) {
		
		if(root == null) {
			return -1;
		}
		
		int ldepth = findHeight(root.left)+1;
		int rdepth = findHeight(root.right)+1;
		
		if(ldepth>=rdepth) {
			return ldepth;
		}else {
			return rdepth;
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
