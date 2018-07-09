package com.home.leetcode;

import java.util.Stack;

public class Spiral2DMatrix {

	public static void main(String[] args) {
		
		int depth=4;
		int i=0;
		int[][] ans = new int[depth][depth];
		
		//R, D, L, U
		int[] xDir = {0, 1, 0, -1};
		int[] yDir = {1, 0, -1, 0};
		int dir=0, val=1;
		int xOffset=i, yOffset=i;
		
		while (i<depth/2) {
			while(xOffset>=(0+i) && xOffset<(depth-i) && yOffset>=(0+i) && yOffset<(depth-i)) {
				if(ans[xOffset][yOffset]!=0) break;
				ans[xOffset][yOffset]=val;
				
				//Validate this goes ++ always
				val++;
				xOffset+=xDir[dir];
				yOffset+=yDir[dir];
			}

			//reset the offsets
			xOffset-=xDir[dir];
			yOffset-=yDir[dir];

			dir=(dir+1)%4;
			//resembles next level.
			if(dir==0) i++;
			
			xOffset+=xDir[dir];
			yOffset+=yDir[dir];
			
		}

		for (i=0;i<depth;i++) {
			for (int j=0;j<depth;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
