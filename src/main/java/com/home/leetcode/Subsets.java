package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[]{1,2,3}));
		List<List<Integer>> soln = new ArrayList<>();
		new Subsets().subsetsR(new int[]{1,2,3}, 3, soln);
		System.out.println(soln);

	}

	/*
	 
	 */
	private void subsetsR(int[] nums, int index, List<List<Integer>> soln) {
		
		if(index==0) {
			soln.add(new ArrayList<>());
		}
		
		
		return;
	}
	
	
	
	
	
	
	
	
	
	

	public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> valueLists = new ArrayList<>();
        
        int val=(int) Math.pow(2, nums.length)-1;
        while(val>=0) {
            valueLists.add(subsets(nums, val));
            val--;
        }
        return valueLists;
    }
    
    public List<Integer> subsets(int[] nums, int val) {
        List<Integer> valueList = new ArrayList<>();
        //Check number of ones.
        int bitPos=0;
        while(val/(int)Math.pow(2,bitPos) > 0) {
            if(((val>>bitPos) & 1) == 1) {
                valueList.add(nums[bitPos]);
            }
            bitPos++;
        }
        return valueList;
    }
}
