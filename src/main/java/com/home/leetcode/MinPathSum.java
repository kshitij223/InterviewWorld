package com.home.leetcode;

public class MinPathSum {

	public static void main(String[] args) {
		int[][] arr= {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(new MinPathSum().minPathSum(arr));
	}
	
	public int minPathSum(int[][] grid) {
        if (grid==null) return Integer.MAX_VALUE;
        
        return minPathSumHelper(grid, 0, 0);
    }
    
    private int minPathSumHelper(int[][] grid, int x, int y) {
        if(x==(grid.length-1) &&  y==(grid[0].length-1)) return grid[x][y];
        if (x<0||x>grid.length-1) {
        	return Integer.MAX_VALUE;
        }
        if (y<0||y>grid[0].length-1) {
        	return Integer.MAX_VALUE;
        }
           
        int right = minPathSumHelper(grid, x, y+1);
        int down = minPathSumHelper(grid, x+1, y);
        
        return right<down? (grid[x][y]+right):(grid[x][y]+down);
    }

}
