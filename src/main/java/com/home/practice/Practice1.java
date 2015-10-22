package com.home.practice;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(shortURLtoID("abc12".toCharArray()));
		System.out.println(uRLtoID("abc12".toCharArray()));
	}
	
	private static long shortURLtoID(char[] shortURL)
	{
	    long id = 0; // initialize result
	 
	    // A simple base conversion logic
	    for (int i=0; i < shortURL.length; i++)
	    {
	        if ('a' <= shortURL[i] && shortURL[i] <= 'z')
	          id = id*62 + shortURL[i] - 'a';
	        if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
	          id = id*62 + shortURL[i] - 'A' + 26;
	        if ('0' <= shortURL[i] && shortURL[i] <= '9')
	          id = id*62 + shortURL[i] - '0' + 52;
	    }
	    return id;
	}
	
	private static long uRLtoID(char[] shortURL) {
	    long id = 0; // initialize result
	 
	    // A simple base conversion logic
	    for (int i=0; i < shortURL.length; i++) {
	        if ('a' <= shortURL[i] && shortURL[i] <= 'z')
	          id += Math.pow(62, shortURL.length-i-1)*(shortURL[i] - 'a');
	        if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
	        	id += Math.pow(62, shortURL.length-i-1)*(shortURL[i] - 'A' + 26);
	        if ('0' <= shortURL[i] && shortURL[i] <= '9')
	        	id += Math.pow(62, shortURL.length-i-1)*(shortURL[i] - '0' + 52);
	    }
	    return id;
	}
}
