package com.home.leetcode;

public class Regex_AnotherTry {

	public static void main(String[] args) {
		System.out.println(isRegex("accbxcb", "a*", 0, 0));
		//System.out.println(isPermutation("accbc", "ac?b", 0, 0));

	}
	
	
	/*
	 * a*b = accbxcb
	 * a*bcb = accbcb
	 */
	private static boolean isRegex(String str, String pattern, int sIndex, int pIndex) {
		if(str==null&&pattern==null) return true;
		if(str==null||pattern==null) return false;
		
		if(sIndex==str.length() && pIndex==pattern.length()) return true;
		if(sIndex==str.length() || pIndex==pattern.length()) return false;
		
		if(str.charAt(sIndex) == pattern.charAt(pIndex)) {
			return isRegex(str, pattern, sIndex+1, pIndex+1);
		}
		
		if(pattern.charAt(pIndex) == '?') {
			return isRegex(str, pattern, sIndex+1, pIndex+1) 
					|| isRegex(str, pattern, sIndex, pIndex+1);
		}
		
		if(pattern.charAt(pIndex) == '*') {
			int lastStrIndex=-1;
			
			if(pattern.length()==pIndex+1) {
				return true;
			} else {
				char nxtPatChar = pattern.charAt(pIndex+1);
				//search for its last occurrence in str
				for(int i=str.length()-1; i>sIndex; i--) {
					if(str.charAt(i) == nxtPatChar) {
						lastStrIndex =i;
						break;
					}
				}
			}
			if(lastStrIndex==-1) return false;
			int temp=sIndex;
			for(int i=sIndex; i<lastStrIndex; i++) {
				if(isRegex(str, pattern, temp+1, pIndex+1)) {
					return true;
				}
				temp++;
			}
		}
		
		//String does not match
		return false;
		
	}

}
