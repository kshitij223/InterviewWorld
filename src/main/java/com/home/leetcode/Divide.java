package com.home.leetcode;

public class Divide {

	public static void main(String[] args) {
		System.out.println(Integer.MIN_VALUE);
//		System.out.println(Math.abs(Integer.MAX_VALUE));
//		System.out.println(-2147483648);
		//System.out.println(new Divide().divide(-2147483648, -1));
		System.out.println(new Divide().divide(2147483647, -1));
		//System.out.println(new Divide().divide(-3, -1));
String s; s.substr
	}

	public int divide(int dividend, int divisor) {
        boolean isDividendNeg = dividend<0;
        boolean isDivisorNeg = divisor<0;
        
        //we keep numbers negative to live in wider range.
        if (dividend>0) {
        	dividend = dividend-dividend-dividend;
        }
        
        if (divisor>0) {
        	divisor = divisor-divisor-divisor;
        }
        
        int run=0;
        int temp=0;
        while (true) {
            temp+=divisor;
            if (temp<dividend || temp==Integer.MAX_VALUE) break;
            run++;
        }
        
        if ((isDividendNeg && !isDivisorNeg) || 
           (!isDividendNeg && isDivisorNeg)) {
            return (run-run-run);
        }
        //System.out.println(run);
        
        if (run==Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return run;
    }
	
}
