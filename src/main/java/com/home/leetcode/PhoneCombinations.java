package com.home.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneCombinations {

	public static void main(String[] args) {
		System.out.println(new PhoneCombinations().letterCombinations("45"));

	}
	
	public List<String> letterCombinations(String digits) {
        if(digits==null||digits.isEmpty()) return new ArrayList<>();
        
        Map<String, String> map = new HashMap<>();
        map.put("2","abc");map.put("3","def");map.put("4","ghi");map.put("5","jkl");
        map.put("6","mno");map.put("7","pqrs");map.put("8","tuv");map.put("9","wxyz");
        
        List<String> ans = new ArrayList<>();
        try {
            letterCombinationsHelper(digits, map, ans, "");
        } catch(Exception e) {
            ans=null;
        }
        return ans;
    }
    
    public void letterCombinationsHelper(String digits, Map<String, String> map, List<String> ans, String re)
        throws Exception {
        if(digits.isEmpty()) {
            ans.add(re);
            return;
        }
        
        char digit = digits.charAt(0);
        if(!map.containsKey(""+digit)) throw new Exception("Malformed input");
        
        String chars = map.get(""+digit);
        int i=0;
        while(i<chars.length()) {
            letterCombinationsHelper(digits.substring(1), map, ans, re+chars.charAt(i));    
            i++;
        }
    }

}
