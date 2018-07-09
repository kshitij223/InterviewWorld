package com.home.leetcode;

public class ConsecutiveOnes {

	public static void main(String[] args) {
		int[] nums = {1,0,1,1,0,1};
		System.out.println(new ConsecutiveOnes().findMaxConsecutiveOnes(nums));

	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        
        //Take a sliding window approach.
        int start=0, end=0, max=0, localMax=0;
        int tempZero=0;
        
        // will only happen during the start
        while (tempZero<=1 && start<=end && end<nums.length) {
            if(nums[end]==0) {
                tempZero++;
                if (tempZero==2) {
                    tempZero=0;
                    start = findNextStart(nums, start);
                    end=start;
                    continue;
                }
            }
            if(end<nums.length) {
                localMax = end-start+1;
            } else {
                localMax = end-start;
            }
            end++;
            
            if(max<localMax) max=localMax;
        }
        return max;
    }
    
    private int findNextStart(int[] nums, int start) {
        int i=0;
        for(i=start; i<nums.length; i++) {
            if (nums[i]==0) {
                i=i+1; break;
            }
        }
        return i;
    }

}
