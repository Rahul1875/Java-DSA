package src.com.pack.tree;

public class DeleteNodesBST {
	
	Node root;
	
	public DeleteNodesBST() {
		root = null;
	}
	
	public static void main(String[] args) {
		
		DeleteNodesBST tree = new DeleteNodesBST();
		tree.root = new Node(12);
		tree.root.left = new Node(5);
		tree.root.left.left = new Node(3);
		tree.root.left.left.right = new Node(4);
		tree.root.left.right = new Node(7);
		tree.root.left.right.right = new Node(9);
		tree.root.left.left.left = new Node(1);
		tree.root.right = new Node(15);
		tree.root.right.left = new Node(13);
		tree.root.right.right = new Node(17);
		tree.root.right.right.right = new Node(19);
		
		System.out.println("Inorder Traversal of the Tree");
		tree.traverse(tree.root);
		
		System.out.println();
		System.out.println("Delete Node");
		tree.deleteNode(tree.root,1);
		
		System.out.println("Inorder Traversal After Deleting the Node");
		tree.traverse(tree.root);
		
		//System.out.println("Is Node Deleted : "+flag);
	}
	
	
	//Deleting means - inserting null or overriding the value
	private Node deleteNode(Node root,int data) {
		
		if(root==null) {
			return null;
		} else if(root.key>data) {
			 root.left = deleteNode(root.left, data);
		} else if(root.key<data) {
			root.right = deleteNode(root.right, data);
		} else {			
			// Case 1: node to be deleted has no children (it is a leaf node)
			if (root.left == null && root.right == null)
			{
				// update root to null
				return null;
			}

			// Case 2: node to be deleted has two children
			else if (root.left != null && root.right != null)
			{
				// find its in-order predecessor node
				Node predecessor = maximumKey(root.left);

				// Copy the value of predecessor to current node
				root.key = predecessor.key;

				// recursively delete the predecessor. Note that the
				// predecessor will have at-most one child (left child)
				root.left = deleteNode(root.left, predecessor.key);
			}

			// Case 3: node to be deleted has only one child
			else
			{
				// find child node
				Node child = (root.left != null)? root.left: root.right;
				root = child;
			}
		}
		return root;
	}


	private Node maximumKey(Node root) {
		
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}

	private void traverse(Node root) {
		if(root!=null) {
			traverse(root.left);
			System.out.print(root.key+"->");
			traverse(root.right);
		}
		
	}

}
