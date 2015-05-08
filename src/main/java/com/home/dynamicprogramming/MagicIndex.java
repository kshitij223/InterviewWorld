package com.home.dynamicprogramming;

public class MagicIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-11,2,3,4,5};
		System.out.println(basicSearch(arr, 0, arr.length-1));
		int[] arr2 = {1,2,3,3,3,4,8,9,12};
		System.out.println(complexSearch(arr2, 0, arr2.length-1));
		
	}

	private static int complexSearch(int[] arr, int start, int end) {
		if (arr == null || end<start) {
			return -1;
		} else {
			int mid = (start + end)/2;
			if (mid == arr[mid]) {
				return mid;
			} else if (mid>arr[mid]) {
				int val = complexSearch(arr, mid+1, end);
				if (val == -1) {
					int pseudoEnd = Math.min(mid, arr[mid]);
					val = complexSearch(arr, start, pseudoEnd);
				}
				return val;
			} else if (mid < arr[mid]) {
				int val = complexSearch(arr, start, mid-1);
				if (val == -1) {
					int pseudoStart = Math.max(mid, arr[mid]);
					val = complexSearch(arr, pseudoStart, end);
				}
				return val;
			}
			return -1;
		}
	}

	private static int basicSearch(int[] arr, int start, int end) {
		int mid = (start + end)/2;
		if (start>end || arr==null) {
			return -1;
		}
		
		if (mid == arr[mid]) {
			return mid;
		} else {
			if (mid>arr[mid]) {
				return basicSearch(arr, mid+1, end);
			} else {
				return basicSearch(arr, start, mid-1);
			}
		}
		
	}

}
