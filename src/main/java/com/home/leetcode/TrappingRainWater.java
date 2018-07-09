package com.home.leetcode;

public class TrappingRainWater {

	public static void main(String[] args) {
		System.out.println(new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

	}
	
	public int trap(int[] height) {
        if (height==null || height.length==0) return 0;
        
        // Keep going forward till we get a building >= curr
        // If not, take the one which is max amongst the smaller ones.
        // Smaller one is always used to get water limit.
        int vol=0;
        for (int i=0; i<height.length;) {
            int nxt = findNextBuilding(height, i);
            if(nxt==-1) break;
            vol += getVolume(height, i, nxt);
            i=nxt;
        }
        return vol;
        
    }
    
    private int getVolume(int[] height, int curr, int nxt) {
        //Get buildings lesser than both ends
        int vol=0, pointer = height[curr]<height[nxt]?height[curr]:height[nxt];
        for (int i=curr+1;i<nxt;i++) {
            vol+=pointer-height[i];
        }
        
        return vol;
    }
    
    private int findNextBuilding(int[] height, int curr) {
        int max=-1;
        for (int i=curr+1; i<height.length; i++) {
            if (height[i]>=height[curr]) {
                max=i; break;
            }
            if(max==-1 || height[i]>=height[max]) {
                max=i;
            }
        }
        return max;
    }

}
