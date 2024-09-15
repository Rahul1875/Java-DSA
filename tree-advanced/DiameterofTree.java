package com.pack.tree;


class Node 
{ 
    int data; 
    Node left, right; 
  
    public Node(int item) 
    { 
        data = item; 
        left = right = null; 
    } 
}

public class DiameterofTree {

	
	static int res = 0;
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.left.right = new Node(8);
  
        
        diameter(root);
        System.out.println("The diameter of given binary tree is : "
                           + res);
		
        
	}

	private static int diameter(Node root) {
		
		if(root==null) {
			return 0;
		}
		
		int left = diameter(root.left);
		int right = diameter(root.right);
		
		int temp = 1+ Integer.max(left, right);
		
		int ans = Integer.max(temp, 1+left+right);
		
		res = Integer.max(ans, res);
		
		return temp;
	}

}
