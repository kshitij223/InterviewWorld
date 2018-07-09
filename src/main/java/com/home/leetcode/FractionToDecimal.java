package com.home.leetcode;

import java.util.TreeSet;

public class FractionToDecimal {

	public static void main(String[] args) {
		System.out.println(new FractionToDecimal().fractionToDecimal(1, 99));
		TreeSet<Long> set = new TreeSet<Long>();
		set.subs
		
	}

	public String fractionToDecimal(int numerator, int denominator) {
        if (denominator==0) {
            if (numerator>0)
                return ""+Integer.MAX_VALUE;
            else
                return ""+Integer.MIN_VALUE;
        }
        
        // How to know when to put ()
        String ans = ""+numerator/denominator;
        int remainder = numerator - ((numerator/denominator)*denominator); // 1 and 6
        if (remainder!=0) ans=ans+".";
        String remainderStr = ""+remainder;
        String newRem="";
        String quot = "";
        String oldQuot = "";
        while (true) {
            numerator = remainder*10;
            ans=ans+(numerator)/denominator;
            newRem = ""+(numerator - ((numerator/denominator)*denominator));
            quot=""+numerator/denominator;
            
            // Could not still divide
            if (numerator/denominator == 0) {
                if (newRem.equals("0")) {
                    ans+=quot;
                    break;
                }
                remainder*=10;
                oldQuot=quot;
                remainderStr = newRem;
                continue;
            } 
            
            if (newRem.equals(remainderStr)) {
                String repeatingPattern = "("+(oldQuot+quot)+")";
                ans = ans.substring(0, ans.length()-(oldQuot+quot).length()) + repeatingPattern;
                break;
            }
            if (newRem.equals("0")) break;
            remainderStr = newRem;
            remainder = (numerator - ((numerator/denominator)*denominator));
            oldQuot="";
            // Have max precision length
        }
        
        if ((numerator<0 && denominator>0) &&
                (numerator>0 && denominator<0)) {
            ans="-"+ans;
        }
        return ans;
    }
}
