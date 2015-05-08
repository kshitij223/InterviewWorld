package com.home.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * There is a hierarchy in a company represented as -
 * a, m1
 * b, m1
 * m1, m2
 * m2, c
 * c, c
 * 
 * Find how many employees are under a given employee at one time.
 * @author kshitij
 *
 */
public class Hierarchy {

	public static void main(String[] args) {
		Map<String, String> empMap = new HashMap<String, String>();
		empMap.put("a", "m1");
		empMap.put("b", "m1");
		empMap.put("m1", "m2");
		empMap.put("m2", "c");
		empMap.put("c", "c");
		
		buildTree(empMap);

	}

	private static TreeNode buildTree(Map<String, String> empMap) {
		Map<String, TreeNode> result = new HashMap<String, TreeNode>();
		TreeNode root = null;
		for (String emp : empMap.keySet()) {
			String manager = empMap.get(emp);
			if (!result.containsKey(manager)) {
				TreeNode manNode = new TreeNode(manager);
				result.put(manager, manNode);
				if (emp.equals(manager)) {
					root = result.get(manager);
					continue;
				} else {
					if (result.containsKey(emp)) {
						manNode.children.add(result.get(emp));
					} else {
						manNode.children.add(new TreeNode(emp));
					}
				}
				
			} else {
				TreeNode manNode = result.get(manager);
				if (result.containsKey(emp)) {
					manNode.children.add(result.get(emp));
				} else {
					manNode.children.add(new TreeNode(emp));
				}
			}
		}
		return root;
	}

}

class TreeNode {
	String name;
	List<TreeNode> children;
	
	TreeNode (String name) {
		this.name = name;
		children = new ArrayList<TreeNode>();
	}
}