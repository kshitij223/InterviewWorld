package com.home.leetcode;

public class IncreasingTrplet {

	public static void main(String[] args) {
		System.out.println(increasingTriplet_v1(new int[]{4,5,1,2,3}));

	}
	
	public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) {
            	return true;
            }
        }
        return false;
    }

	public static boolean increasingTriplet_v1(int[] nums) {
		if(nums==null||nums.length<3) return false;

        int second_min=-1, min=0;
        for (int i=1; i<nums.length; i++) {
            
            if(nums[i]>nums[min]) {
                if(second_min==-1 || nums[i]<nums[second_min]) second_min=i;
                else if(nums[i]>nums[second_min]) return true;
            } else {
            	min=i;
            }
        }
        
        return false;
    }
}
