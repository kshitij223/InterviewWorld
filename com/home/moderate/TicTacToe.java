package com.home.moderate;

public class TicTacToe {

	public static boolean checkValidity(int[][] matrix, int n) {
		boolean ans = false;
		int row=0;
		int col=0;
		
		// Rows
		if (matrix[0][0] != 0)
		for (row=0; row<n; row++) {
			for (col=1; col<n; col++) {
				if(matrix[row][col] != matrix[row][col-1]) {
					break;
				}
			}
			if (col==n) {
				return true;
			}
		}
		
		// Column
		if (matrix[0][0] != 0)
		for (col=0; col<n; col++) {
			for (row=1; row<n; row++) {
				if(matrix[row][col] != matrix[row-1][col]) {
					break;
				}
			}
			if (row==n) {
				return true;
			}
		}
		
		//left diagonal
		if (matrix[0][0] != 0)
		for (row=1; row<n; row++) {
			if(matrix[row-1][row-1] != matrix[row][row]) {
				break;
			}
		}
		if (row==n) {
			return true;
		}
		
		//right diagonal
		if (matrix[0][n-1] != 0)
		for (row=1; row<n; row++) {
			if(matrix[row-1][n-row] != matrix[row][n-row-1]) {
				break;
			}
		}
		if (row==n) {
			return true;
		}
		
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
