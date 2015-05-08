package com.home.tree;



public class BST {
	
//	public void insert(TreeNode root, int data) {
//		if (root == null) {
//			root = new TreeNode();
//			root.info = data;
//		}
//		else {
//			while(root != null) {
//				if (data<root.info) {e
//					root.nodesToLeft++;
//					root = root.left;
//				}
//				else if (data>root.info) {
//					root = root.right;
//				}
//				else {
//					System.out.println("Found duplicate");
//					return;
//				}
//			}			
//		}
//	}
	
	static TreeNode root = null;
	public void insert (TreeNode node, int data) {
		if (root == null) {
			root = new TreeNode(data);
			root.parent = null;
			return;
		}
		
		if (data == node.info) {
			System.out.println("Duplicate node found");
		} else if (node.info > data) {
			if (node.left == null) {
				TreeNode temp = new TreeNode(data);
				node.left = temp;
				temp.parent = node;
			} else {
				insert(node.left, data);
			}
		} else {
			if (node.right == null) {
				TreeNode temp = new TreeNode(data);
				node.right = temp;
				temp.parent = node;
			} else {
				insert(node.right, data);
			}
		}
	}
	
	public void inorder (TreeNode root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.info);
		inorder(root.right);
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
		BST obj = new BST();
		obj.insert(root, 1);
		obj.insert(root, 2);
		obj.insert(root, 3);
		obj.insert(root, 4);
		obj.insert(root, 4);
		obj.insert(root, 6);
		obj.insert(root, 7);
		obj.insert(root, 8);
		
		obj.inorder(root);
	}

}
