package src.com.pack.tree;

public class LowestCommonAncestor {
	
	Node root;
	
	public LowestCommonAncestor() {
		root =null;
	}
	
	public static void main(String[] args) {
		
		LowestCommonAncestor tree = new LowestCommonAncestor();
		tree.root = tree.insert(tree.root,50); 
		tree.root = tree.insert(tree.root,30); 
		tree.root = tree.insert(tree.root,20); 
		tree.root = tree.insert(tree.root,40); 
//		tree.root = tree.insert(tree.root,35);
		tree.root = tree.insert(tree.root,70); 
		tree.root = tree.insert(tree.root,60); 
		tree.root = tree.insert(tree.root,80);
		
		Node lca = tree.lowCommonAncestor(tree.root, 60,80);
		System.out.println("Lowest Common Ancestor : "+ lca.key);
	}
	
	
	private Node lowCommonAncestor(Node root, int node1, int node2) {
		
		if(root==null) {
			return null;
		}
		if(root.key>node1 && root.key>node2) {
			root = lowCommonAncestor(root.left, node1, node2);
		} 
		if(root.key<node1 && root.key<node2){
			root = lowCommonAncestor(root.right, node1, node2);
		}
		return root;		
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
