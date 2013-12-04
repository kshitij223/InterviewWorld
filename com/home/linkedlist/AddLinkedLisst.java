package com.home.linkedlist;

import java.util.Stack;

public class AddLinkedLisst {

	static Node start;
	public static void main(String[] args) {
		LinkedList lListA = new LinkedList();
		lListA.insertEnd(3);
		//lListA.insertEnd(6);
		lListA.insertEnd(7);

		LinkedList lListB = new LinkedList();
		lListB.insertEnd(3);
		//lListB.insertEnd(6);
		lListB.insertEnd(6);

		addReverseLists(lListA.start, lListB.start, 0);
		lListA.print(start);
		
		System.out.println();
		Node n2 = addListsStack(lListA.start, lListB.start);
		lListA.print(n2);
		
		System.out.println();
		Node n3 = addListsRecurse(lListA.start, lListB.start);
		lListA.print(n3);
	}

	public static Node addReverseLists(Node rootA, Node rootB, int carry) {
		if (rootA == null && rootB == null && carry == 0) {
			return null;
		}
		int first = 0;
		if (rootA != null) { 
			first = rootA.info;
		}

		int second = 0;
		if (rootB != null) { 
			second = rootB.info;
		}

		int sum = first+second+carry;
		Node n = new Node();
		n.info = sum%10;
		n.next = null;

		Node oneUp = addReverseLists(rootA == null ? null : rootA.next, rootB == null ? null : rootB.next, sum/10);
		if (oneUp == null) {
			start = n;
		}
		else {
			oneUp.next = n;
		}
		return n;
	}

	public static Node addListsStack(Node rootA, Node rootB) {
		if (rootA == null && rootB == null) {
			return null;
		}
		
		Stack<Integer> stackA = new Stack<Integer>();
		Stack<Integer> stackB = new Stack<Integer>();

		while (rootA != null) {
			stackA.push(rootA.info);
			rootA = rootA.next;
		}

		while (rootB != null) {
			stackB.push(rootB.info);
			rootB = rootB.next;
		}

		int carry = 0;
		Node start = null;
		while(!stackA.isEmpty() && !stackB.isEmpty()) {
			int sum = 0;
			sum += carry + stackA.pop() + stackB.pop();
			if (start == null) {
				start = new Node();
				start.info = sum % 10;
			}
			else {
				Node n = new Node();
				n.info = sum % 10;
				n.next = start;
				start = n;
			}
			carry = sum / 10;
		}
		
		
		Stack<Integer> stack = new Stack<Integer>();
		if (stackA.isEmpty()) {
			stack = stackB;
		}
		else if (stackB.isEmpty()) {
			stack = stackA;
		}
		
		while (!stack.isEmpty() || carry != 0) {
			int sum = 0, stackTop = 0;
			if (!stack.isEmpty()) {
				stackTop = stack.pop();
			}
			sum += carry + stackTop;
			if (start == null) {
				start = new Node();
				start.info = sum % 10;
			}
			else {
				Node n = new Node();
				n.info = sum % 10;
				n.next = start;
				start = n;
			}
			carry = sum / 10;
		}
		return start;
	}
	
	public static Node addListsRecurse(Node rootA, Node rootB) {
		int len1=0, len2=0;
		
		Node temp = rootA;
		while(temp != null) {
			++len1;
			temp = temp.next;
		}
		
		temp = rootB;
		while(temp != null) {
			++len2;
			temp = temp.next;
		}
		
		if (len1<len2) {
			rootA = doPadding(rootA, len2-len1);
		}
		else if (len1>len2) {
			rootB = doPadding(rootB, len1-len2);
		}
		
		return addListHelper(rootA, rootB).node;
	}
	
	private static Node doPadding(Node root, int n) {
		for (int i=0; i<n; i++) {
			Node dummyNode = new Node();
			dummyNode.info = 0;
			if (root == null) {
				root = dummyNode;
				root.next = null;
			}
			else {
				dummyNode.next = start;
				root = dummyNode;
			}
		}
		return root;
	}

	private static IntWrapper addListHelper(Node rootA, Node rootB) {
		if (rootA == null && rootB == null) {
			return null;
		}
		
		IntWrapper result = addListHelper(rootA.next, rootB.next);
		
		int sum=0;
		Node ret = new Node();
		if (result != null) {
			sum += result.carry;
			ret.next = result.node;
		}
		if (rootA != null) {
			sum += rootA.info;
		}
		if (rootB != null) {
			sum += rootB.info;
		}
		
		IntWrapper wrap = new IntWrapper();
		ret.info = sum%10;
		
		wrap.carry = sum/10;
		wrap.node = ret;
		
		return wrap;
	}
	
}