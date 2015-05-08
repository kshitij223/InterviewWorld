package com.home.linkedlist;

public class LinkedListPalindrome {

	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		lList.insertBeginning(7);
		lList.insertBeginning(6);
		lList.insertBeginning(5);
		lList.insertBeginning(6);
		lList.insertBeginning(7);
		
		Wrapper checkPalindrome = checkPalindrome(lList.start);
		System.out.println(checkPalindrome.result);
	}

	private static Wrapper checkPalindrome(Node start) {
		if (start == null || start.next == null) {
			return new Wrapper(null, false);
		}
		return checkPalindromeHelper(start, start.next);
		
	}

	private static Wrapper checkPalindromeHelper(Node slow, Node fast) {
		if (fast==null || fast.next==null) {
			return new Wrapper (slow.next, true);
		}
		
		Wrapper res = checkPalindromeHelper(slow.next, fast.next.next);
		if (!res.result) {
			return res;
		}
		if (slow.info == res.node.info) {
			return new Wrapper (res.node.next, true);
		} else {
			return new Wrapper (res.node.next, false);
		}
		
	}
}

class Wrapper {
	boolean result;
	Node node;
	
	Wrapper (Node node, boolean result) {
		this.result = result;
		this.node = node;
	}
}
