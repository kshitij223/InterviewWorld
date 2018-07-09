package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		List<String> result = new ArrayList<>();
		permutaion("abcd", 0, result);
		System.out.println(result);
	}
	
	public static void permutaion(String str, int index, List<String> result) {
		if(index==str.length()-1) {
			result.add(str);
			return;
		}
		
		//swap index character with all positions once
		char[] charArray = str.toCharArray();
		for(int i=index; i<charArray.length; i++) {
			char temp = charArray[index];
			charArray[index] = charArray[i]; 
			charArray[i] = temp; 
			
			permutaion(new String(charArray), index+1, result);
		}
	}
}