package com.home.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordSquares {

	public static void main(String[] args) {
		List<List<String>> wordSquares = new WordSquares().wordSquares(new String[]{"wall","lead","area","lady","ball"});
		System.out.println(wordSquares);
		
		HashSet<char[]> hashSet = new HashSet<>(Arrays.asList(new char[]{}));
	}

	public List<List<String>> wordSquares(String[] words) {
    
		if (words==null || words.length==0) return null;
		List<List<String>> ans = new ArrayList<>();
		
		for (int i=0; i<words.length; i++) {
			Set<String> visitedWords = new HashSet<>();
			List<List<String>> temp = findSquare(words[i], words, visitedWords, 0, 0, new ArrayList<List<String>>(), 0);
			if (temp!=null && !temp.isEmpty()) ans.addAll(temp);
		}
		
		//ans.stream().filter(ansL -> ansL.size()!=words[0].length()).collect(Collectors.toList());
		return ans;
    }

	private List<List<String>> findSquare(String curr, String[] words,
			Set<String> visitedWords, int wordNum, int index, List<List<String>> soln, int solnNum) {
		
		boolean newWords=true;
		if (index==curr.length()) {
			newWords=false;
		}
		
		if(newWords) {
			for (int i=0; i<words.length; i++) {
				boolean firstHit=false;
				if(!visitedWords.contains(words[i])) {

					if (curr.charAt(index) == words[i].charAt(0)) {
						if (!visitedWords.contains(words[i])) {
							visitedWords.add(words[i]);
						}
						
						if(firstHit) solnNum++;
						if (soln.size()<=solnNum) {
							soln.add(new ArrayList<String>());
						}
						soln.get(solnNum).add(words[i]);
						soln = findSquare(curr, words, visitedWords, wordNum, index+1, soln, solnNum);
						firstHit=true;
					}
				}
			}
		} else {
			wordNum++;
			while (wordNum<curr.length()) {
				curr = soln.get(solnNum).get(wordNum);
				List<String> currList = soln.get(solnNum);
				for (int i=0; i<curr.length(); i++) {
					if (curr.charAt(i) == currList.get(i).charAt(wordNum)) {
						//continue;
					} else {
						return null;
					}
				}
				wordNum++;
			}
		}
		
		return soln;
	}
	
	private void resetmap(Map<Character, Integer> tMap) {
        Map<Character, Integer> tMap_new = new HashMap<>();
        for (Character char: tMap.keySet()) {
            tMap_new.put(char, tMap.get(char));
        }
        return tMap_new;
    }
}
