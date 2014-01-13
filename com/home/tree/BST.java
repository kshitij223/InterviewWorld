package com.home.tree;



public class BST {
	
	public void insert(TreeNode root, int data) {
		if (root == null) {
			root = new TreeNode();
			root.info = data;
		}
		else {
			while(root != null) {
				if (data<root.info) {
					root.nodesToLeft++;
					root = root.left;
				}
				else if (data>root.info) {
					root = root.right;
				}
				else {
					System.out.println("Found duplicate");
					return;
				}
			}			
		}
	}
	
	public int getRank(TreeNode root, int toFind) {
		if (root == null) {
			return -1;
		}
		
		if (toFind == root.info) {
			return root.nodesToLeft;
		}
		
		if (root.info < toFind) {
			if (root.right != null) {
				return root.nodesToLeft + 1 + getRank(root.right, toFind);
			}
			else {
				return -1;
			}
		}
		else {		
			return 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
