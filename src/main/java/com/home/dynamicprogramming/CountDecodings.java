package com.home.dynamicprogramming;

/*
 * Input:  digits[] = "121"
Output: 3
// The possible decodings are "ABA", "AU", "LA"

Input: digits[] = "1234"
Output: 3
// The possible decodings are "ABCD", "LCD", "AWD"
 */
public class CountDecodings {

	public static void main(String[] args) {
		String str = "1234";
		System.out.println(countDecodings(str));
	}

	
	private static int countDecodings(String str) {
		
		if (str == null) {
			return -1;
		}
		if (str.isEmpty()) {
			return 1;
		}
		
		int count = 0;
		for (int i=0; i<str.length(); i++) {
			String newString = str.substring(0,i+1);
			int newInt = Integer.parseInt(newString);
			if (newInt>=1 && newInt<=26) {
				count += countDecodings(str.substring(i+1));
			}
		}
		
		return count;
	}

}
