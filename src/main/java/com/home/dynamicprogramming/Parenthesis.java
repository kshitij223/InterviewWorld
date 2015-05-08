package com.home.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parenthesis {

	/**
	 * for n=2, we should produce: ()(); (()) and so on.
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(parenthesis(3));
		List<String> list = new ArrayList<>();
		char[] str = new char[6];
		parenthesisScratch(list, 3, 3, str, 0);
		System.out.println(list);
	}

	private static void parenthesisScratch(List<String> list, int numL, int numR, char[] str, int count) {
		if (numL<0 || numR<0) return;
		
		if (numL==0 && numR==0) {
			String str2 = String.copyValueOf(str);
			list.add(str2);
		} else {
			if (numL > 0) {
				str[count] = '(';
				parenthesisScratch(list, numL-1, numR, str, count+1);
			}
			
			if (numR > numL) {
				str[count] = ')';
				parenthesisScratch(list, numL, numR-1, str, count+1);
			}
		}
	}

	private static Set<String> parenthesis(int i) {
		if (i==0) {
			Set<String> list = new HashSet<>();
			list.add("");
			return list;
		}
		
		Set<String> list = parenthesis(i-1);
		Set<String> compList = new HashSet<>();
		for (String paren : list) {
			for (int index=0; index<paren.length(); index++) {
				if (paren.charAt(index) == '(') {
					String str = insertChar(paren, index);
					compList.add(str);
				}
			}
			
			if (!compList.contains("()" + paren)) {
				compList.add("()" + paren);
			}
		}
		return compList;
	}

	private static String insertChar(String paren, int i) {
		return paren.substring(0, i+1) + "()" + paren.substring(i+1);
	}

}
