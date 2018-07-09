package com.home.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestNoReps {

	public static void main(String[] args) {
		System.out.println(new LongestNoReps().lengthOfLongestSubstring("dvdf"));

	}

	public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty()) return 0;
        
        Set<Character> uniqueSet = new HashSet<>();
        int longest=0;
        int end=0;
        while (end<s.length()) {
            
            if(uniqueSet.contains(s.charAt(end))) {
                uniqueSet = new HashSet<>();
                uniqueSet.add(s.charAt(end));
            } else {
                uniqueSet.add(s.charAt(end));
                if(longest<uniqueSet.size()) longest=uniqueSet.size();
            }
            end++;
        }
        
        return longest;
    }
}
