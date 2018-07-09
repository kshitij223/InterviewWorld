package com.home.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

	public static void main(String[] args) {
		String S = "a", T = "aa";
		System.out.println(new MinWindowSubstring().minWindow(S, T));

	}
	
	public String minWindow(String s, String t) {
        if (s==null || t==null) return "";
        String ans="";
        int start=0, end=0;
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            tMap.put(t.charAt(i), -1);
        }
        
        while (true) {
            if(start==s.length() || end==s.length()) break;
            
            if(tMap.containsKey(s.charAt(end))) {
                if (s.charAt(end) == s.charAt(start)) {
                    // move start forward
                    while (true) {
                        if (start==end || tMap.containsKey(s.charAt(start))) break;
                        start++;
                    }
                }
                tMap.put(s.charAt(end), end);
                end++;
                
            } else {
                end++;
            }
            
            if (!anyCollected(tMap)) {
                start++;
            }
            if(allCollected(tMap)) {
            	if ("".equals(ans) || s.substring(start, end).length()<ans.length()) {
            		ans = s.substring(start, end);
            	}
            	tMap = new HashMap<>();
                for (int i=0; i<t.length(); i++) {
                    tMap.put(t.charAt(i), -1);
                }
                start=end;
            }
        }
        
        return ans;
    }
    
    private boolean allCollected(Map<Character, Integer> tMap) {
        boolean res=true;
        
        for (Character key: tMap.keySet()) {
            if(tMap.get(key)==-1) {
                return false;
            }
        }
        return res;
    }
    
    private boolean anyCollected(Map<Character, Integer> tMap) {
        boolean res=false;
        
        for (Character key: tMap.keySet()) {
            if(tMap.get(key)!=-1) {
                return true;
            }
        }
        return res;
    }

}
