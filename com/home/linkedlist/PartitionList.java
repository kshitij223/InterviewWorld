package com.home.linkedlist;

public class PartitionList {

	static Node start1=null, last1=null;
	static Node start2=null, last2=null;
	
	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		lList.insertEnd(3);
		lList.insertEnd(6);
		lList.insertEnd(1);
		lList.insertEnd(4);
		lList.insertEnd(8);
		lList.insertEnd(5);
		lList.insertEnd(2);
		lList.insertEnd(7);
		lList.insertEnd(4);
		
		Node root = paritionList(lList.start, 4);
		lList.print(root);
	}
	
	public static Node paritionList(Node root, int x) {
		
		if (root == null) {
			return null;
		}
		Node start = null, trav = root, prev = null;
		
		while (trav != null) {
			if (trav.info < x) {
				insertLeft(trav);
				if (start != null) {
					prev.next = prev.next.next;
				}
			}
			else if (trav.info > x) {
				insertRight(trav);
				if (start != null) {
					prev.next = prev.next.next;
				}
			}
			else {
				if (start == null) {
					start = trav;
				}
				prev = trav;
			}
			trav = trav.next;
		}
		last2.next = null;
		last1.next = start;
		prev.next = start2;
		return start1;
	}

	private static void insertLeft(Node trav) {
		if (start1 == null) {
			start1 = trav;
			last1 = trav;
		}
		else {
			last1.next = trav;
			last1 = trav;
		}
		//trav.next = null;
	}
	private static void insertRight(Node trav) {
		if (start2 == null) {
			start2 = trav;
			last2 = trav;
		}
		else {
			last2.next = trav;
			last2 = trav;
		}
		//trav.next = null;
	}
	
}
