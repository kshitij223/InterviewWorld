package com.home.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Bracket {
    int start=0;
    int end=0;
    
    public Bracket(int start, int end) {
    	this.start = start;
    	this.end = end;
    }
}

public class BoldTags {

	public static void main(String[] args) {
		System.out.println(new BoldTags().addBoldTag("abcdef", new String[] {"a","c","e","g"}));

	}
	
	public String addBoldTag(String s, String[] dict) {
        if (s==null||s.isEmpty()) return null;
        if (dict==null||dict.length==0) return s;
        
        Map<String, List<Bracket>> bracketsMap = new HashMap<>();
        
        for (int i=0;i<dict.length;i++) {
            List<Bracket> brackets = new ArrayList<>();
            bracketsMap.put(dict[i], brackets);
            addbrackets(s, dict[i], brackets);
        }
        
        //Check for overlaps
        List<Bracket> ans = new ArrayList<>();
        Map<String, Integer> pointer = new HashMap<>();
        
        while (true) {
            int smallest = Integer.MAX_VALUE;
            Bracket temp = null;
            String tempStr = null;
            boolean isElementLeft = false;
            for (String dictStr: bracketsMap.keySet()) {
                if(!pointer.containsKey(dictStr)) pointer.put(dictStr, 0);
                int index = pointer.get(dictStr);
                List<Bracket> bkList = bracketsMap.get(dictStr);
                if (index==bkList.size()) continue;
                
                isElementLeft = true;
                if (bkList.get(index).start < smallest) {
                    smallest = bkList.get(index).start;
                    temp = bkList.get(index);
                    tempStr = dictStr;
                }
            }
            if(!isElementLeft) break;
            
            //Add or merge with last entry
            if(!ans.isEmpty()) {
            	Bracket last = ans.get(ans.size()-1);
            	//If last is enveloping, then skip
            	if (last.end<temp.end) {
            		if (last.end+1>=temp.start) {
            			last.end = temp.end;
            		} else {
            			ans.add(temp);
            		}
            	}
            } else {
                ans.add(temp);
            }
            
            //Increment the pointer
            pointer.put(tempStr, pointer.get(tempStr)+1);
        }
        
        if (ans==null || ans.isEmpty()) return s;
        
        //List<Bracket> ans has the solution
        String ansStr="";
        int i=0;
        Bracket b = ans.remove(0);
        while(i<s.length()) {
        	if(b!=null && b.start==i) {
        		ansStr+="<b>";
        	} 
        	ansStr+=s.charAt(i);
        	if (b!=null && b.end==i) {
        		ansStr+="</b>";
        		if (!ans.isEmpty()) {
        			b = ans.remove(0);
        		} else {
        			b=null;
        		}
        	} 
        	i++;
        }
        
        return ansStr;
    }
    
    private void addbrackets(String s, String key, List<Bracket> brackets) {
        for (int i=0; i<=(s.length()-key.length()); i++) {
            if(key.equals(s.substring(i, i+key.length()))) {
                brackets.add(new Bracket(i, i+key.length()-1));
            }
        }
    }

}
