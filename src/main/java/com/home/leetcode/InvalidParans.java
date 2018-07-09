package com.home.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class InvalidParans {

	public static void main(String[] args) {
//		List<String> removeInvalidParentheses = new InvalidParans().removeInvalidParentheses("(a)())(b)");
		List<String> removeInvalidParentheses = new InvalidParans().removeInvalidParentheses(")(");
		
		System.out.println(removeInvalidParentheses.toString());

	}

    public List<String> removeInvalidParentheses(String s) {
        if(s==null) return null;
        if(s.isEmpty()) {
        	List<String> list = new ArrayList<String>();list.add("");
        	return list;
        }
        
        Wrapper wrapper = countInvalidParans(s);
        if(wrapper==null) {
            List<String> ans = new ArrayList<String>();ans.add(s);
            return ans;
        }
        
        Set<String> ans = new HashSet<>();
        removeParansHelper(s, wrapper, 0, ans, 0);
        
        if(!ans.isEmpty()) {
        	return new ArrayList<String>(ans);
        } else {
        	List<String> list = new ArrayList<String>();list.add("");
        	return list;
        }
    }
    
    private void removeParansHelper(String s, Wrapper wrapper, int count, Set<String> ans, int index) {
        
        if(count==wrapper.count) {
            if(countInvalidParans(s)==null) {
                ans.add(s);
            }
            return;
        }
        
        while (index<s.length() && count<wrapper.count) {
            if(s.charAt(index)==wrapper.c) {
                //Remove ith element
                removeParansHelper(s.substring(0,index)+s.substring(index+1), 
                                   wrapper, count+1, ans, index+1);
                //Next recursion may start with index+1;
                
            }
            index++;
        }
        
    }
    
    private Wrapper countInvalidParans(String s) {
        Wrapper wrapper = null;
        Stack<Character> inputStk = new Stack<>();
        for(int i=0;i<s.length();i++) {
        	if(s.charAt(i)=='(' || s.charAt(i)==')') {

        		if(inputStk.isEmpty()) {
        			inputStk.push(s.charAt(i));
        		} else {
        			if((inputStk.peek()=='(' && s.charAt(i)==')')) {
        				inputStk.pop();
        			} else {
        				inputStk.push(s.charAt(i));
        			}
        		}
        	}
        }
        
        if(inputStk.size()>0) {
            wrapper = new Wrapper();
            wrapper.c = inputStk.peek();
            wrapper.count = inputStk.size();
        }
        return wrapper;
    }
}

class Wrapper {
    char c;
    int count;
}