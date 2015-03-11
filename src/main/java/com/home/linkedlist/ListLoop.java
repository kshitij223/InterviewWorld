package com.home.linkedlist;


public class ListLoop {

	public static ListNode head = null;
  public static class ListNode {

     public int value;

     public ListNode next;
  }
 
  public static boolean hasLoops( ListNode myList ) {
	  ListNode slow = myList;
	  ListNode fast = myList;
	  while (fast.next != null && fast.next.next != null) {
		 slow = slow.next;
		 fast = fast.next.next;
		 
		 /* Check for cycle, i.e. whether slow and fast collide */
		 if (fast == slow)
			 return true;
	  }
	  return false;
  }

}
