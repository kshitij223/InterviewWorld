package com.home.leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PQueue {

	private static PriorityQueue<String> pQueue = new PriorityQueue<>(5, new StringComp()); 
	public static void main(String[] args) {
		pQueue.add("kshitij");
		pQueue.add("mintu1234567890");
		pQueue.add("lala");
		pQueue.add("kshitijdogra");
		
		Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
		System.out.println(pQueue);
		
		pQueue.poll();
		itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

	}

}
//[lala, kshitij, mintu, kshitijdogra]
//[kshitijdogra, kshitij, lala, mintu]

class StringComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		return -o1.length()+o2.length();
	}
	
}
