package com.home.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Paranthesis {

	public static void main(String[] args) {
		System.out.println(new Paranthesis().generateParenthesis(3));

	}
	
	public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, n, result, "");
        return result;
    }
    
    public void generateParenthesisHelper(int open, int close, List<String> result, String str) {
        if(open==0 && close==0) result.add(str);
        
        String lStr=str;
        if(open>0) {
            lStr+="(";
            generateParenthesisHelper(open-1, close, result, lStr);
        }
        
        String rStr=str;
        if(close>open) {
            rStr+=")";
            close--;
            generateParenthesisHelper(open, close, result, rStr);
        }
            
    }

}
