package com.home.leetcode;

public class OneEditDistance {

	public static void main(String[] args) {
//		System.out.println(isOneEditDistance("abcd", "abd"));
//		System.out.println(isOneEditDistance("abcd", "abced"));
//		System.out.println(isOneEditDistance("abcd", "abed"));
//		System.out.println(isOneEditDistance("abcd", "abee"));
		System.out.println(isOneEditDistance("", "a"));
//		System.out.println(isOneEditDistance("", "ab"));

	}
	
	private static boolean isOneEditDistance(String first, String second) {
		if((first==null && second!=null) ||
				(second==null && first!=null) || Math.abs(first.length()-second.length())>1) {
			return false;
		}
		
		boolean diffFound=false;
		for(int i=0,j=0; i<first.length()&&j<second.length(); i++,j++) {
			
			if(first.charAt(i)!=second.charAt(j)) {
				if(diffFound) return !diffFound;
				
				if(first.length()>second.length()) j--;
				if(second.length()>first.length()) i--;
				diffFound=true;
			}
		}
		
		return true;
	}

}
