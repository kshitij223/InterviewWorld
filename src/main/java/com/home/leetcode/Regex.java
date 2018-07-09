package com.home.leetcode;

public class Regex {

	public static void main(String[] args) {
		System.out.println(new Regex().isMatch("acdcb", "a*c?b"));

	}
	
	public boolean isMatch(String s, String p) {
		if (s==null || p==null || p.isEmpty()) return false;
		if (s.equals("") && p.equals("*")) return true;

		return isMatchHelper(s, p, 0, 0);
	}

	private boolean isMatchHelper(String s, String p, int sIndex, int pIndex) {

		if (s.length()<=sIndex) return true;
		if (p.length()<=pIndex) return false;


		if (p.charAt(pIndex) == '?') {
			return isMatchHelper(s, p, sIndex, pIndex+1) || isMatchHelper(s, p, sIndex+1, pIndex+1);
		}
		else if (s.charAt(sIndex) == p.charAt(pIndex)) {
			return isMatchHelper(s, p, sIndex+1, pIndex+1);
		}
		else if (p.charAt(pIndex) == '*') {
			if (pIndex == p.length()-1) return true;
			//for loop
			int sTemp = sIndex;
			for (; sTemp<s.length(); sTemp++) {
				boolean res = isMatchHelper(s, p, sTemp, pIndex+1);
				if(res) return true;
				//else keep looping
			}

		}
		return false;
	}
}
