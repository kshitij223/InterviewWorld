package com.home.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class WordLadder {

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
		System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord==null || endWord==null || 
            endWord.isEmpty() || beginWord.isEmpty() || wordList==null || wordList.size()==0)
            return 0;
        
        if (beginWord.equals(endWord)) return 0;
        
        Map<String, Set<String>> visitedNodes = new HashMap<>();
        //List<String> visitedNodes = new ArrayList<String>();
        Stack<String> dfsStack = new Stack<>();
        dfsStack.push(beginWord);
        int soln = Integer.MAX_VALUE;
        
        while (!dfsStack.isEmpty()) {
            String top = dfsStack.peek();
            String newStr = getAdjacentWord(top, wordList, visitedNodes, dfsStack);
            if (newStr==null) {
                dfsStack.pop();
                continue;
            }
            
            if (newStr.equals(endWord)) {
            	if (soln>dfsStack.size()) {
            		soln = dfsStack.size();
            	}//[hot, dot, lot, log, dog, cog] [hit, hot, dot, lot, log] ["hit","hot","dot","dog","cog"]
            }
            dfsStack.push(newStr);
        }
        
        return soln==Integer.MAX_VALUE?0:soln;
    }
    
    String getAdjacentWord(String word, List<String> wordList, Map<String, Set<String>> visitedNodes, Stack<String> dfsStack) {
	//String getAdjacentWord(String word, List<String> wordList, List<String> visitedNodes, Stack<String> dfsStack) {
    	if (!visitedNodes.containsKey(word)) {
    		visitedNodes.put(word, new HashSet<String>());
    	}
    	
        for (int i=0; i<word.length(); i++) {
            for (String libraryStr: wordList) {
                if (libraryStr.startsWith(word.substring(0, i)) &&
                        libraryStr.endsWith(word.substring(i+1))) {
                    if (visitedNodes.get(word).contains(libraryStr)) continue;
                	//if (visitedNodes.contains(libraryStr)) continue;

                    // Avoid loops
                    if (dfsStack.contains(libraryStr)) continue;
                    visitedNodes.get(word).add(libraryStr);
                    //visitedNodes.add(libraryStr);
                    return libraryStr;
                }
            }
        }
        
        return null;
    }

}
