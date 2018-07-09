package com.home.dynamicprogramming;


/*
 *     	
	A sequence of numbers is called a zig-zag sequence if the differences between successive 
	numbers strictly alternate between positive and negative. The first difference (if one exists) 
	may be either positive or negative. A sequence with fewer than two elements is trivially a zig-zag sequence.
	
	For example, 1,7,4,9,2,5 is a zig-zag sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, 1,4,7,2,5 and 1,7,4,5,5 are not zig-zag sequences, the first because its first two differences are positive and the second because its last difference is zero.
	Given a sequence of integers, sequence, return the length of the longest subsequence of sequence that is a zig-zag sequence. A subsequence is obtained by deleting some number of elements (possibly zero) from the original sequence, leaving the remaining elements in their original order.
	
	{ 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }
	
	{ 1, 17, 18, 10, 13, 15, 10, 5, 16, 8 }
	Returns: 7
	There are several subsequences that achieve this length. One is 1,17,10,13,10,16,8.

 * 
 * 
 */

class ResWrapper {
	public int len;
	public Boolean isPositive;
	
	ResWrapper(int len, Boolean isPositive) {
		this.isPositive = isPositive;
		this.len = len;
	}
}

public class ZigZag {

	/**
	 * State: position 'i' such that length of the zig zag sequence is max (including it or not)
	 */
	
	ResWrapper longestZigZag(int[] sequence, int len) {
		if (sequence==null || len==0) {
			return new ResWrapper(1, null);
		}
		//{ 1, 17, 5, 10, 13, 15, 10};
		int maxLen = 1;
		Boolean isIncreasing = false;
		for (int i=0; i<len; i++) {
			ResWrapper interim = longestZigZag(sequence, i);
			if (len==4) {
				System.out.println("i="+(i+1)+" , len="+interim.len+" , sign="+interim.isPositive);
			}
			if ((interim.isPositive==null || interim.isPositive) && sequence[i]>sequence[len]) {
				if (interim.len+1>maxLen) {
					isIncreasing = false;
					maxLen = interim.len+1;
				}
				else {
					maxLen = interim.len;
					isIncreasing = interim.isPositive;
				}
			}
			
			if ((interim.isPositive==null || !interim.isPositive) && sequence[i]<sequence[len]) {
				if (interim.len+1>maxLen) {
					isIncreasing = true;
					maxLen = interim.len+1;
				}
				else {
					maxLen = interim.len;
					isIncreasing = interim.isPositive;
				}
			} 
			
		}
		
		return new ResWrapper(maxLen, isIncreasing);
	}
	
	/**
	 * https://community.topcoder.com/stat?c=problem_statement&pm=1259&rd=4493
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		//int[] arr = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
		//1,17,10,13,10,16,8.
		int[] arr = { 1, 17, 5, 3, 4};
		ResWrapper longestZigZag = new ZigZag().longestZigZag(arr, arr.length-1);
		System.out.println(longestZigZag.len);
		System.out.println(longestZigZag.isPositive);
	}
}
