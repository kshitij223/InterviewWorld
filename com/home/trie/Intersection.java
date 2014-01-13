package com.home.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {

	/**
	 * The method returns intersection of two arrays. The result is stored in
	 * a dynamic array (ArrayList) as we do not know the length of the intersection.
	 * 
	 * We keep a count on the number of occurrences of an integer in an array.
	 * This is because for an array A={1,2,3} and B={1,2,2,5} the intersection should
	 * only be {1,2} and not {1,2,2}. The same reasoning for the other case when array
	 * A has repetition and B does not.
	 * 
	 * @param a - First array (source)
	 * @param b - Second array (source)
	 * @return - List (dynamic array) of intersection between arrays a and b
	 *
	public List<Integer> findIntersection(int[] a, int[] b) {
		Map<Integer, Integer> bufferMap = new HashMap<Integer, Integer>();
		List<Integer> intersectionList = new ArrayList<Integer>();
		for (int i=0; i<a.length; i++) {
			if (bufferMap.containsKey(a[i])) {
				int currentCount = bufferMap.get(a[i]);
				bufferMap.put(a[i], currentCount+1);
			}
			else {
				bufferMap.put(a[i], 1);
			}
		}
		
		for (int i=0; i<b.length; i++) {
			if (bufferMap.containsKey(b[i])) {
				int count = bufferMap.get(b[i]);
				if(count>1) {
					bufferMap.put(b[i], count-1);
				} else {
					bufferMap.remove(b[i]);
				}
				intersectionList.add(b[i]);
			}
		}
		return intersectionList;
	}
	public static void main(String[] args) {
		Intersection obj = new Intersection();
		int[] a = {2,3,4,5};
		int[] b = {2,5,2,7,9};
		System.out.println(obj.findIntersection(a, b));
	}*/
	
	public static List<Integer> intersection (List<Integer> a, List<Integer> b) {
		List <Integer> answer = new ArrayList<Integer>();
		Set <Integer> duplicates = new HashSet<Integer>();
		for (Integer el : a) {
			duplicates.add(el);
		}
		for (Integer el : b) {
			if (duplicates.contains(el)) {
				answer.add(el);
				duplicates.remove(el);
			}
		}
		return answer;
	}
	public static void main(String args[]) {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		List<Integer> a3 = new ArrayList<Integer>();
		a1.add(4);
		a1.add(2);
		a1.add(73);
		a1.add(73);
		a1.add(-5);
		
		a2.add(73);
		a2.add(73);
		a2.add(-5);
		a2.add(9);
		a2.add(4);
		a2.add(7);
		a3 = Intersection.intersection(a1, a2);
		for (int i : a3)
		{
			System.out.println(i);
		}
	}
}