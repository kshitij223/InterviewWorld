package com.home.regex;

public class RegexCalculator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(recurse("a*b", "anhgb"));

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

}
