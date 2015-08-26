package com.home.regex;

public class RegexCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(recurse2("ab*c", "abccc", 0, 0));

	}
	
	public static boolean recurse(String pattern, String str) {
		if (str == null || pattern == null) {
			return false;
		}
		if (str.length() == 0 &&
				pattern.length() == 0) {
			return true;
		}
		else if (str.length() == 0) {
			return false;
		}
		else if (pattern.length() == 0) {
			return false;
		}
		if (pattern.charAt(0) != '*') {
			if (pattern.charAt(0) == str.charAt(0)) {
				return recurse (pattern.substring(1), str.substring(1));
			} 
			else {
				return false;
			}
		}
		if (pattern.charAt(0) == '*') {
			if (pattern.charAt(1) != str.charAt(0)) {
				return recurse(pattern,str.substring(1));
			}
			if (pattern.charAt(1) == str.charAt(0)) {
				return recurse(pattern.substring(2), str.substring(1));
			}
		}
		return false;
		
	}
	
	// ab*c = abbc
	public static boolean recurse2(String pattern, String str, int patIndex, int strIndex) {
		if (pattern == null || str == null) {
			return false;
		}
		
		if ((strIndex == str.length())) {
			if (patIndex == pattern.length() || 
					pattern.charAt(patIndex) == '*') {
				return true;
			}
		}
		
		if ((strIndex == str.length()) ||
				patIndex == pattern.length()) {
			return false;
		}
		
		if (str.charAt(strIndex) == pattern.charAt(patIndex)) {
			return recurse2(pattern, str, patIndex+1, strIndex+1);
		}
		
		if ((pattern.charAt(patIndex) == '*')) {
			if (patIndex < pattern.length()-1 && str.charAt(strIndex+1) != pattern.charAt(patIndex+1)) {
					return recurse2(pattern, str, patIndex, strIndex+1);
				
			} else {
				return recurse2(pattern, str, patIndex+1, strIndex+1);
			}
		}
		
		if ((patIndex < pattern.length()-1) && (str.charAt(strIndex) == pattern.charAt(patIndex+1))) {
			return recurse2(pattern, str, patIndex+2, strIndex+1);
		}
		
		return false;
	}

}
