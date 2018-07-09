package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class TreeDiameter {
	
	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root==null) return null;
        List<List<Integer>> result = new ArrayList<>();
        verticalOrderHelper(root, result, -1);
        return result;
    }
    
    public int verticalOrderHelper(TreeNode root, List<List<Integer>> result, int degree) {
        if(root==null) return 0;
        
        int tempDegree = verticalOrderHelper(root.left, result, degree-1);
        if(degree<0) degree=tempDegree;
        
        if(result.size()<=degree) result.add(new ArrayList<>());
        result.get(degree).add(root.val);
        
        verticalOrderHelper(root.right, result, degree+1);
        
        return degree+1;
    }

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		n1.right = new TreeNode(5);

		TreeNode n2 = new TreeNode(2);
		n2.left = new TreeNode(1);
		n2.right = new TreeNode(3);
		
		n1.left=n2;
		
		//System.out.println(new TreeDiameter().diameterOfBinaryTree(n1));
		System.out.println(new TreeDiameter().verticalOrder(n1));
	}

	public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        
        return diameterOfBinaryTreeHelper(root);
    }
    
    public int diameterOfBinaryTreeHelper(TreeNode root) {
        if(root==null) return 0;
        
        int leftSize = diameterOfBinaryTreeHelper(root.left);
        int rightSize = diameterOfBinaryTreeHelper(root.right);
        
        if(leftSize>rightSize) return leftSize+1;
        else return rightSize+1;
    }
}
