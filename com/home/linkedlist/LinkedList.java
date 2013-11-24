package com.home.linkedlist;

public class LinkedList {
	private static Node start;
	private static Node end;
	
	private static void insertBeginning(int info) {
		if (start == null) {
			start = new Node();
			start.info = info;
			end = start;
		}
		else {
			Node n = new Node();
			n.info = info;
			n.next = start;
			start = n;
		}
		
	}
	
	private static void insertEnd(int info) {
		Node n = new Node();
		n.info = info;
		if (end == null) {
			end = new Node();
			end.info = info;
			start = end;
		}
		else {
			n.next = null;
			end.next = n;
			end = n;
		}
	}
	
	private static void insertMiddle(int search, int info) {
		Node n = new Node();
		n.info = info;
		Node trav = start;
		if (start == null) {
			insertBeginning(info);
		}
		else {
			while(trav.next != null) {
				if (trav.info == search) {
					n.next = trav.next;
					trav.next = n;	
					break;
				}
				else {
					trav = trav.next;
				}
			}
		}
	}
	
	private static void deleteBeginning() {
		if (start == null) {
			return;
		}
		else {
			if (start == end) {
				start = end = null;
			}
			else {
				start = start.next;
			}
		}
	}
	
	private static void deleteEnd() {
		if (end == null) {
			return;
		}
		else {
			if (start == end) {
				start = end = null;
			}
			else {
				Node trav = start;
				while (trav.next != end) {
					trav = trav.next;
				}
				end = trav;
				trav.next = null;
			}
		}
	}
	
	private static void deleteMiddle(int info) {
		if (start == null) {
			return;
		}
		else {
			if (start == end) {
				if (start.info == info) {
					start = end = null;
				}
				else {
					System.out.println("item not found.");
					return;
				}
			}
			else {
				Node trav = start;
				Node prev = null;
				while (trav.next != null) {
					if (trav.info == info) {
						prev.next = trav.next;
						break;
					}
					else {
						prev = trav;
						trav = trav.next;
					}
				}
			}
		}
	}
	
	private static void print() {
		Node trav = start;
		while (trav != null) {
			System.out.print(trav.info + " ");
			trav = trav.next;
		}
	}

	public static void main(String[] args) {
		insertBeginning(7);
		insertBeginning(6);
		insertBeginning(5);
		print();
		System.out.println("\n------------------------");
		insertEnd(4);
		print();
		System.out.println("\n------------------------");
		insertMiddle(6, 9);
		print();
		System.out.println("\n------------------------");
		deleteBeginning();
		print();
		System.out.println("\n------------------------");
		deleteEnd();
		print();
		System.out.println("\n------------------------");
		deleteMiddle(9);
		print();
	}

}
