package src.com.pack.tree;

public class InorderSuccessorTree {

	Node root;
	
	InorderSuccessorTree(){
		root = null;
	}
	
	public static void main(String[] args) {
	
		InorderSuccessorTree tree = new InorderSuccessorTree();
		tree.root = tree.insert(tree.root,50); 
		tree.root = tree.insert(tree.root,30); 
		tree.root = tree.insert(tree.root,20); 
		tree.root = tree.insert(tree.root,40); 
	//	tree.root = tree.insert(tree.root,35);
		tree.root = tree.insert(tree.root,70); 
		tree.root = tree.insert(tree.root,60); 
		tree.root = tree.insert(tree.root,80);

		Node node = tree.inorderSuccessor(tree.root,null,50);
		System.out.println("Inorder Successor of the given node is :"+node.key);
		
	}	

	
	private Node inorderSuccessor(Node root,Node succ,int data) {
		
		if(root==null) {
			return null;
		}
		if(root.key ==data) {
			if(root.right!=null) {
				return findMinNode(root.right);
			}
		}else if(root.key>data) {
			succ = root;
			return inorderSuccessor(root.left, succ, data);
		} else {
			return inorderSuccessor(root.right, succ, data);
		}
		return succ;
	}

	
	private Node findMinNode(Node root) {
		
		while(root.left!=null) {
			root = root.left;
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
