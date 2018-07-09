package com.home.leetcode;

public class MaxProdSubarray {

	public static void main(String[] args) {
		System.out.println(new MaxProdSubarray().maxProduct2(new int[]{2,-5,-2,-4,3}));
		System.out.println(new MaxProdSubarray().maxProduct2(new int[]{0}));
		System.out.println(new MaxProdSubarray().maxProduct2(new int[]{-2,-3}));
		new HashSet<>(new char[] {});
	}
	
	public int maxProduct(int[] nums) {
        int restartPointer=-1, maxProd=Integer.MIN_VALUE;
        
        int runningProd=0;
        for (int i=0; i<nums.length; ) {
            if (nums[i]==0) {
                if (restartPointer!=-1) {
                    i=restartPointer;
                    restartPointer=-1;
                    runningProd=0;
                }
                if (maxProd<0) {
                    maxProd=0;
                }
            } else {
            	if (runningProd==0) {
            		runningProd=nums[i];
            	} else {
            		runningProd*=nums[i];
            	}
                if (nums[i]<0) {
                    if (runningProd<0) {
                        restartPointer=i+1;
                    } else {
                        restartPointer=-1;
                    }
                }
                if (runningProd>maxProd) maxProd=runningProd;
            }
            
            if (i==nums.length-1 && runningProd<0 && restartPointer!=-1) {
                i=restartPointer;
                runningProd=1;
            } else {
                i++;
            }
        }
        
        //if (runningProd>maxProd) maxProd=runningProd;
        return maxProd;
    }
	
	public int maxProduct2(int[] A) {
		   int min;
		   int res = A[0], max = min = A[0]; // max, min means max and min product among the subarrays whose last element is A[i].
		   for (int i = 1; i < A.length; i++) {
			   if (A[i] > 0) {
				   max = Math.max(max * A[i], A[i]);
				   min = Math.min(min * A[i], A[i]);			   
			   }
			   else {
				   int lastMax = max;
				   max = Math.max(min * A[i], A[i]);
				   min = Math.min(lastMax * A[i], A[i]);			   			   
			   }
			   res = Math.max(res, max);
		   }
		   return res;
		}

}
