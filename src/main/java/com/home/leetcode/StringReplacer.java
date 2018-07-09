package com.home.leetcode;

public class StringReplacer {

	public static void main(String[] args) {
		String src = "abcbcdfabd";
		String from = "abc";
		String to = "xyabc";

		int start=0, end=from.length();
		String ans="";
		//keep a window
		while (end<src.length()) {
			if (from.equals(src.substring(start, end))) {
				ans+=to;
				start=end;
				end++;
			} else {
				if(end-start==from.length()) {
					ans+=src.charAt(start);
					start++;
					end++;
				} else {
					end++;
				}
			}
		}

		if(start<end) {
			ans+=src.substring(start, end);
		}
		System.out.println(ans);

	}

}
