package com.home.leetcode;

public class ShortestPalindrome {

	public static void main(String[] args) {
		//System.out.println(shortestPalindrome2("aabba")); //abbabba, abbaabba
		//System.out.println(shortestPalindrome2("axbba")); //abbxbba, abbxaxbba
		System.out.println(shortestPalindrome2("abdbba"));

	}
	
	public static String shortestPalindrome(String s) {
        String ans="";
        int end=s.length()-1, start=0;
        while (end>=start) {
            ans+=s.charAt(end);
            if(s.charAt(start)==s.charAt(end)) {
                start++;
                end--;
            } else {
                end--;
            }
        }
        
        //Add remaining
        start=0;
        while (start<s.length()) {
            ans+=s.charAt(start);
            start++;
        }
        return ans;
    }
	
	public static String shortestPalindrome2(String s) {
	    int i=0; 
	    int j=s.length()-1;
	 
	    while(j>=0){
	        if(s.charAt(i)==s.charAt(j)){
	            i++;
	        }
	        j--;
	    }
	 
	    if(i==s.length())
	        return s;
	 
	    String suffix = s.substring(i);
	    String prefix = new StringBuilder(suffix).reverse().toString();
	    String mid = shortestPalindrome2(s.substring(0, i));
	    return prefix+mid+suffix;
	}

}
