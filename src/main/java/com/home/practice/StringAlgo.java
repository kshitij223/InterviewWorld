package com.home.practice;

public class StringAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compression("g  eeks     for ge  eeks  "));
	}
	
	/**
	 * Input:  "g  eeks     for ge  eeks  "
	 * Output: "geeksforgeeks"
	 * @param str
	 * @return
	 */
	private static char[] compression(String str) {
		char[] arr = str.toCharArray();
		int current=0, insert=0;
		for (int i=0; i<arr.length; i++) {
			if (arr[current] == ' ') {
				current++;
			} else {
				if (insert<current) {
					arr[insert] = arr[current];
				}
				current++;
				insert++;
			}
		}
		arr[insert] = '\0';
		for (int i=0; i<arr.length; i++) {
			if (arr[i]=='\0') {
				break;
			}
		//	System.out.println(arr[i]);
		}
		//System.out.println(arr);
		String ans = new String(arr);
		System.out.println(ans.charAt(insert));
		return arr;
	}

}
