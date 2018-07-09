package com.home.dynamicprogramming;

public class LongestIncresingSub {

	static int max_ref;
	public static void main(String...strings) {
		//int [] arr = {-1, 0, 1, 0, 3, 4, 7, 5, 9};
		int[] arr = {50, 3, 4, 1, 9};
		//int[] arr = {7, 2, 5, 6};
		//int arr[] = {50, 3, 10, 7, 40, 80};
		//int arr[] = {3, 10, 7, 8};
		
		System.out.println(findSubsequence(arr, arr.length));
		_lis(arr, arr.length);System.out.println(max_ref);
	}

	private static int findSubsequence(int[] arr, int n) {
		if (n==1) return 1;
		
		int max=1;
		for (int i=1; i<n; i++) {
			int tillI = findSubsequence(arr, i);
			if (arr[i-1]<arr[n-1] && tillI+1>max) {
				max=tillI+1;
			}
		}
		
		return max;
	}
	
	static int _lis(int arr[], int n)
	   {
	       // base case
	       if (n == 1)
	           return 1;
	 
	       // 'max_ending_here' is length of LIS ending with arr[n-1]
	       int res, max_ending_here = 1;
	 
	        /* Recursively get all LIS ending with arr[0], arr[1] ...
	           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
	           max ending with arr[n-1] needs to be updated, then
	           update it */
	        for (int i = 1; i < n; i++)
	        {
	            res = _lis(arr, i);
	            if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
	                max_ending_here = res + 1;
	        }
	 
	        // Compare max_ending_here with the overall max. And
	        // update the overall max if needed
	        if (max_ref < max_ending_here)
	           max_ref = max_ending_here;
	 
	        // Return length of LIS ending with arr[n-1]
	        return max_ending_here;
	   }
}
