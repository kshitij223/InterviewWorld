package com.home.dynamicprogramming;

import java.util.HashMap;

/*
 * Given the mobile numeric keypad. You can only press buttons that are up, left, right or 
 * down to the current button. You are not allowed to press bottom row corner buttons (i.e. * and # ).
 * Given a number N, find out the number of possible numbers of given length.
 */
class Node {
	int x;
	
	@Override
	public int hashCode() {
		return x;	
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Node &&
				((Node) o).x == this.x) {
			return true;
		} else {
			return false;
		}
	}
}

public class MobileKeypad {

	public static void main(String[] args) {
		int[][] keypad = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
		int count=0;
		for (int i=0; i<keypad.length; i++) {
			for (int j=0; j<keypad[0].length; j++) {
				if (keypad[i][j]==-1) {
					continue;
				}
				//System.out.println("Sending over - " + i + " " + j);
				count+=findPatterns(keypad, 2, i, j);
			}
		}
		System.out.println(count);
	}

	private static int findPatterns(int[][] keypad, int n, int i, int j) {
		if (i<0 || j<0 || j>=keypad[0].length || i>=keypad.length) {
			return 0;
		}
		
		if (keypad[i][j]==-1) {
			return 0;
		}
		
		if (n==1) {
			//System.out.println(i + " " + j);
			return 1;
		}
		
		return  findPatterns(keypad, n-1, i, j) +
				findPatterns(keypad, n-1, i-1, j) +
				findPatterns(keypad, n-1, i, j-1) +
				findPatterns(keypad, n-1, i+1, j) +
				findPatterns(keypad, n-1, i, j+1);
	}

}
