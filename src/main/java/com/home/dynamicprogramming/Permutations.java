package com.home.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

	public static void main(String[] args) {
		
		// Write permutations of the given string.
		System.out.println(permute("abc"));
		//System.out.println("abc".substring(0, 1));
		
		// Write permutations with repetitions allowed.
		Set<String> set = new HashSet<>();
		permuteWithReps("aba", "", set);
        System.out.println(set);
	}

	private static void permuteWithReps(String input, String sofar, Set<String> set) {
	        if (input.equals("")) {
	            set.add(sofar);
	        }
	        for (int i = 0; i < input.length(); i++) {
	            char c = input.charAt(i);
	            if (input.indexOf(c, i + 1) != -1)
	                continue;
	            permuteWithReps(input.substring(0, i) + input.substring(i + 1), sofar + c, set);
	        }
	    }

	// For part two of the problem. 
	private static List<String> permute(String str) {
		if (str == null || str.isEmpty()) {
			List<String> ans = new ArrayList<>(1);
			ans.add("");
			return ans;
		}
		
		List<String> ans = permute(str.substring(0, str.length() - 1));
		char toInsert = str.charAt(str.length() - 1);
		List<String> permAns = new ArrayList<>();
		for (String tempStr: ans) {
			char[] charArr = tempStr.toCharArray();
			for (int i=0; i<=charArr.length; i++) {
				String str1 = insertChar(tempStr, i, toInsert);
				permAns.add(str1);
			}
		}
		return permAns;
		
	}

	private static String insertChar(String str, int pos, char toInsert) {
		String part = str.substring(0, pos);
		String endPart = str.substring(pos, str.length());
		return part + toInsert + endPart;
	}

}
