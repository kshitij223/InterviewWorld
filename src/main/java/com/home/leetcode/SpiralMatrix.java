package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		//System.out.println(matrix.length);
		
		System.out.println(new SpiralMatrix().spiralOrder(matrix));
		
		

	}

	public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) return null;
        
        int curr=0, loop = matrix.length/2;
        List<Integer> spiralArr = new ArrayList<>();
        while (curr<=loop) {
            printTop(spiralArr, matrix, curr);
            printRight(spiralArr, matrix, curr);
            printBottom(spiralArr, matrix, curr);
            printLeft(spiralArr, matrix, curr);
            curr++;
        }
        return spiralArr;
    }
    
    private void printTop (List<Integer> spiralArr, int[][] matrix, int curr) {
        // curr will be the row, col start and go till matrix[0].length-curr
        int i=curr;
        while (i<(matrix[0].length-curr)) {
            spiralArr.add(matrix[curr][i]);
            i++;
        }
    }
    
    private void printRight (List<Integer> spiralArr, int[][] matrix, int curr) {
        int i=curr+1;
        while (i<(matrix.length-curr)) {
            spiralArr.add(matrix[i][matrix[0].length-curr-1]);
            i++;
        }
    }
    
    private void printBottom (List<Integer> spiralArr, int[][] matrix, int curr) {
        int i=matrix[0].length-curr-2;
        while (i>=curr) {
            spiralArr.add(matrix[matrix.length-curr-1][i]);
            i--;
        }
    }
    
    private void printLeft (List<Integer> spiralArr, int[][] matrix, int curr) {
        int i=matrix.length-curr-2;
        while (i>curr) {
            spiralArr.add(matrix[i][curr]);
            i--;
        }
    }
	
}
