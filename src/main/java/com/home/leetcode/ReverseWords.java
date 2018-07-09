package com.home.leetcode;

public class ReverseWords {

	public static void main(String[] args) {
		System.out.println(new ReverseWords().reverseWords("   a   b  c d   e  "));
		//System.out.println(new ReverseWords().reverseWords("a    b "));
	}

	public String reverseWords(String s1) {
        if (s1==null || s1.isEmpty()) return s1;

        
        StringBuilder s = new StringBuilder(s1);
        //even or odd
        int end = s.length()-1;
        //by reference
        reverseHelper(s, 0, end);
        
        int start = 0;
        int len = s.length();
        for (int i=0; i<len; i++) {
            if (s.charAt(i) == ' ') {
            	// reverse the word
                reverseHelper(s, start, i-1);
                start = i+1;
            }
        }
        //  e   d c  b   a  
        //reverse the last word
        reverseHelper(s, start, s.length()-1);
        trimSpaces(s);
        
        return s.toString();
    }
    
    private StringBuilder reverseHelper(StringBuilder s, int start, int end) {
        if (end<=0 || start<0 || (start>=end)) return s;
        
        for (; start<end; start++, end--) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
        }
        return s;
    }
    
    private int leftShift(StringBuilder s, int start) {
        while (start<s.length()-2) {
        	s.setCharAt(start, s.charAt(start+1));
            start++;
        }
        s.deleteCharAt(start);
        return s.length();
    }
    
    private void trimSpaces(StringBuilder s) {
        int start = 0;
        while (start<s.length() && s.charAt(start) == ' ') {
            leftShift(s, start);
        }
        
        int len = s.length();
        for (int i=0; i<len; i++) {
        	if (i>0 && s.charAt(i-1)==' ' && s.charAt(i) == ' ') {
        		leftShift(s, i); i--;
        	}
        	len = s.length();
        }
        //a   b
        //Find last occuring ' '
        int end = s.length()-1;
        while (end>0 && s.charAt(end) == ' ') {
            end--;
        }
        
        // remove all last spaces
        while (end<s.length()-1) {
            leftShift(s, end+1);
        }
    }
}
