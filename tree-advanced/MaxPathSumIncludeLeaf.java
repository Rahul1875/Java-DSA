package com.pack.tree;

public class MaxPathSumIncludeLeaf {

	static int res;
	public static void main(String[] args) {
		
		Node root = new Node(-15); 
        root.left = new Node(5); 
        root.right = new Node(6); 
        root.left.left = new Node(-8); 
        root.left.right = new Node(1); 
        root.left.left.left = new Node(2); 
        root.left.left.right = new Node(6); 
        root.right.left = new Node(3); 
        root.right.right = new Node(9); 
        root.right.right.right = new Node(0); 
        root.right.right.right.left = new Node(4); 
        root.right.right.right.right = new Node(-1); 
        root.right.right.right.right.left = new Node(10); 
		
    	maxSumPath(root);
		System.out.println("Max Path Sum From leaf to leaf : "+res);
        
	}
	
	
	private static int maxSumPath(Node root) {
		
		
		if(root==null) {
			return 0;
		}
		
		int left = maxSumPath(root.left);
		int right = maxSumPath(root.right);
		
		int temp = Integer.max(left, right)+root.data;
		if(root.left==null && root.right==null) {
			temp = Integer.max(temp,root.data);
		}
		int ans = Integer.max(temp,left+right+root.data);
		
		res = Integer.max(ans,res);
		
		return temp;
		
	}

}
