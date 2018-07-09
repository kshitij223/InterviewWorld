package com.home.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("ccd"));

	}

	public String longestPalindrome(String s) {
        if(s==null||s.isEmpty()) return null;
        return longestPalindromeHelper(s,0,s.length()-1, new HashMap<>());
    }
    
    public String longestPalindromeHelper(String s, int start, int end, Map<String, String> cache) {
        if(start>end) return null;
        
        if(cache.containsKey(start+"#"+end)) return cache.get(start+"#"+end);
            
        if(isPalindrome(s.substring(start,end+1))) {
            return s.substring(start,end+1);
        }
        
        String left=longestPalindromeHelper(s, start+1, end, cache);
        String right=longestPalindromeHelper(s, start, end-1, cache);
        
        cache.put((start+1)+"#"+end, left);
        cache.put(start+"#"+(end-1), right);
        
        if(left==null && right==null) return null;
        if(left==null) return right;
        if(right==null) return left;
        
        return left.length()>right.length()?left:right;
        
    }
    
    private boolean isPalindrome(String s) {
        if(s==null||s.isEmpty()) return false;
        int start=0, end=s.length()-1;
        while(start<end) {
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;end--;
        }
        return true;
    }
	
}
