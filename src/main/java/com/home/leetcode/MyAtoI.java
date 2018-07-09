package com.home.leetcode;

public class MyAtoI {
	public static void main(String...strings) {
		System.out.println(new MyAtoI().myAtoi("4193 with words"));
	}
	
    public int myAtoi(String str) {
        int res = 0;
        if (str==null || str.isEmpty()) {
            return res;
        } else {
            boolean isNegative = false;
            String validInt = "";
            for (int i=0; i<str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    continue;
                }
                
                if ((str.charAt(i) < '0' || str.charAt(i) > '9')
                    && str.charAt(i) != '-') {
                    
                    return myAtoiHelper(validInt, isNegative);
                }
                
                if (str.charAt(i) == '-') {
                    if (!validInt.equals("")) {
                        // return whatever we have till now.
                        return myAtoiHelper(validInt, isNegative);
                    }
                    if (isNegative) return myAtoiHelper(validInt, isNegative);
                    isNegative = true;
                    continue;
                }
                
                validInt += str.charAt(i);
                
            }
            return myAtoiHelper(validInt, isNegative);
        }
    }
    
    public int myAtoiHelper(String str, boolean isNegative) {
    	if (str==null || str.isEmpty()) return 0;
    	
        int maxPow = str.length() - 1;
        int res = 0;
        for (int i=0; i<str.length(); i++) {
            res+= Math.pow(10, maxPow) * (str.charAt(i) -'0');
            maxPow = maxPow-1;
        }
        
        if (isNegative) return -1*res;
        return res;        
    }
}