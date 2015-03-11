package com.home.trie;

import java.util.ArrayList;

public class SampleTrie {

	public static boolean searchAndAdd(TrieNode root, TrieNode prev, char[] str, int index) {
		if (root == null) {
			return false;
		}
		if (root.childLinks == null) {
			insertNode(root, str, 0);
			return false;
		}
		if (index < str.length) { 
			for (TrieNode child : root.childLinks) {
				if (child.alphabet == str[index]) {
					return searchAndAdd(child, root, str, ++index);
				}
			}
		}
		if (index == str.length &&
				prev.endOfWord) {
			return true;
		}
		else {
			insertNode(prev, str, index);
			return false;
		}
	}
	
	private static void insertNode(TrieNode prev, char[] str, int index) {
		if (index == str.length &&
				!prev.endOfWord) {
			prev.endOfWord = true;
		}
		else if (index != str.length) {
			for (int i = index; i<str.length; i++) {
				TrieNode node = new TrieNode();
				node.alphabet = str[i];
				if (prev.childLinks == null) {
					prev.childLinks = new ArrayList<TrieNode>(1);
					prev.childLinks.add(node);
				}
				else {
					prev.childLinks.add(node);
				}
				prev = node;
			}
			prev.endOfWord = true;			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieNode root = new TrieNode();
		char[] arr1 = {'b','o','y','s'};
		System.out.println(searchAndAdd(root, null, arr1, 0));
		char[] arr2 = {'b','o','y'};
		System.out.println(searchAndAdd(root, null, arr2, 0));
		System.out.println(searchAndAdd(root, null, arr2, 0));

	}

}
