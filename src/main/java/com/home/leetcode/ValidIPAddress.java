package com.home.leetcode;

public class ValidIPAddress {

	public static void main(String[] args) {
		System.out.println(new ValidIPAddress().validIPAddress("01.01.01.01"));

	}
	
	public String validIPAddress(String IP) {
		if (IP==null || IP.isEmpty() ||
                IP.endsWith(".") || IP.endsWith(":")) return "Neither";
        
        if (IP.contains(".")) {
            // validate for IPv4
            String[] arr = IP.split("\\.");
            if (arr.length!=4) return "Neither";
            
            for (int i=0; i<4; i++) {
                try {
                    String classStr = arr[i];
                    if (classStr==null || classStr.isEmpty() || classStr.startsWith("-")) return "Neither";
                    if (classStr.equals("0")) continue;
                    int class_1 = Integer.parseInt(classStr);
                    
                    //check string does not start with a 0.
                    boolean isDigit=false;
                    for (int j=0; j<classStr.length(); j++) {
                        if (classStr.charAt(j)!='0') {
                            isDigit=true;
                        } 
                        else if (!isDigit) {
                           return "Neither";  
                        }
                    }
                    
                    if (!(class_1>=0 && class_1<256)) {
                        return "Neither";
                    } 
                } catch(Exception e) {
                   return "Neither"; 
                }
            }
            return "IPv4";
        } else {
            // validate for IPv6
            String[] arr = IP.split(":");
            if (arr.length!=8) return "Neither";
            for (int i=0; i<8; i++) {
                try {
                    String classStr = arr[i];
                    if (classStr==null || classStr.isEmpty() || classStr.length()>4) return "Neither";
                    if (classStr.equals("0")) continue;
                    for (int j=0; j<classStr.length(); j++) {
                        if (!(Character.isDigit(classStr.charAt(j)) ||
                                (classStr.charAt(j)>='a' && classStr.charAt(j)<='f') ||
                                (classStr.charAt(j)>='A' && classStr.charAt(j)<='F'))) {
                            return "Neither";     
                        }
                    }
                } catch(Exception e) {
                   return "Neither"; 
                }
            }
            return "IPv6";
        }
    }

}
