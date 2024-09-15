package src.com.pack.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	Node root;
	
	LevelOrderTraversal(){
		root = null;
	}
	
	public static void main(String[] args) {	
		
		LevelOrderTraversal tree = new LevelOrderTraversal();
		tree.root = tree.insert(tree.root,50); 
		tree.root = tree.insert(tree.root,30); 
		tree.root = tree.insert(tree.root,20); 
		tree.root = tree.insert(tree.root,40); 
	//	tree.root = tree.insert(tree.root,35);
		tree.root = tree.insert(tree.root,70); 
		tree.root = tree.insert(tree.root,60); 
		tree.root = tree.insert(tree.root,80);

		System.out.println("Level Order Traversal of the Tree");
		tree.bfs(tree.root);
	
	}	

	
	private void bfs(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()) {			
			Node temp = queue.poll();
			System.out.print(temp.key+"->");
			if(temp.left!=null) {
				queue.add(temp.left);
			}
			if(temp.right!=null) {
				queue.add(temp.right);
			}			
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
