package com.home.leetcode;

public class BitSmallestPower {

	public static void main(String[] args) {
		System.out.println(nextPowerOf2(5));
		System.out.println(isPowerOfTwo(31));
		System.out.println(isPowerOfTwo(32));
		System.out.println(isPowerOfTwo(64));
	}

	static int nextPowerOf2(int n) {
		int x=n;
		
		//Find the MS 1.
		int count=0, index=-1;
		while (n!=0) {
			n=n>>1;
			index++;
		}
	
		if(((int)Math.pow(2, index))!=x) {
			return 1<<(index+1);
		} else {
			return 1<<index;
		}
	}
	
	static boolean isPowerOfTwo(int n) {
		return (n&(n-1))==0;
    }
}
