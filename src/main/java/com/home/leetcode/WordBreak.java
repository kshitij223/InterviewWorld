package com.home.leetcode;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		List<String> wordDict = Arrays.asList("a", "aa", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa");
		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
        if (s==null || s.isEmpty()) return false;
        
        return wordBreakHelper(s, wordDict, 1);
    }
    
    private static boolean wordBreakHelper(String s, List<String> wordDict, int index) {
    	if (s.length()<=0) return true;
        
        for (; index<=s.length(); index++) {
            String temp = s.substring(0, index);
            if(wordDict.contains(temp)) {
                boolean isSuccess = wordBreakHelper(s.substring(index), wordDict, 1);
                if(isSuccess) return isSuccess;
            }
        }
        return false;
    }
}
