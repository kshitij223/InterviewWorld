package com.home.leetcode;

public class Islands {

	public static void main(String[] args) {
		char[][] grid = new char[][]{{'1','1','1'},{'1','0','1'},{'1','1','1'}};
		System.out.println(new Islands().numIslands(grid));
	}
	
	public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0) return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        int islands=0;
        //repeat till we have islands
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(!visited[i][j] && grid[i][j]=='1') {
                    traverse(grid,i,j,visited);
                    islands++;
                } 
                //else do nothing
            }
        }
        
        return islands;
    }
    
    //Do DFS
    private void traverse(char[][] grid, int i, int j, boolean[][] visited) {
        if(i<0 || i>=grid.length
            || j<0 || j>=grid[0].length) {
            return;
        }
        try {
        	if(visited[i][j] || grid[i][j]=='0') return;
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
        visited[i][j]=true;
        traverse(grid, i, j+1, visited);
        traverse(grid, i+1, j, visited);
        traverse(grid, i, j-1, visited);
        traverse(grid, i-1, j, visited);
    }

}
