package com.home.leetcode;

public class WordTyping {

	public static void main(String[] args) {
		System.out.println(new WordTyping().wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6));

	}

	private int wordsTyping(String[] sentence, int rows, int cols) {
        int[] next = new int[sentence.length];
        int[] times = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            int curr = i;
            int col = 0;
            int time = 0;
            // Adding up words cannot exceeds cols.
            while (col + sentence[curr].length() <= cols) {
                // Add this word and a space.
                col = col + sentence[curr++].length() + 1;
                // We reach the end of the word in a sentence.
                if (curr == sentence.length) {
                    curr = 0;
                    time++;
                }
            }
            next[i] = curr;
            times[i] = time;
        }
        
        int res = 0;
        int curr = 0;
        for (int i = 0; i < rows; i++) {
            res += times[curr];
            curr = next[curr];
        }
        return res;
    }
}
