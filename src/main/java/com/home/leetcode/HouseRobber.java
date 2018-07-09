package com.home.leetcode;

public class HouseRobber {

	public static void main(String[] args) {
		System.out.println(rob(new int[]{2,3,2}));
		System.out.println(rob(new int[]{1,2,3,1}));

	}
	
	public static int rob(int[] nums) {
        
        int first = robHelper(nums, 0, true/*isFirstSelected*/);
        int second = robHelper(nums, 1, true/*isFirstSelected*/);
        
        return first>second?first:second;
    }
    
    private static int robHelper(int[] nums, int houseNum, boolean isFirstSelected) {
    
        if (houseNum>=nums.length) return 0;
        if (houseNum==nums.length-1 && isFirstSelected) return 0;
        
        return nums[houseNum] + robHelper(nums, houseNum+2, isFirstSelected);
    }

}
