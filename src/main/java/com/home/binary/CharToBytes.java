package com.home.binary;

public class CharToBytes {

	public static void main(String[] args) {
		int d=-2;
		while (d!=0) {
			System.out.println(d&0x1);
			d=d>>>1;
		}
		//System.out.println(d>>>29);
		char[] charArr = {'a','b','2','c','d'};
		byte[] byteArr = new byte[charArr.length];
		
		// Assuming ASCII
		for (int i=0; i<charArr.length; i++) {
			byte b = (byte)charArr[i];
			byteArr[i]=b;
		}
		
		for (int i=0; i<byteArr.length; i++) {
			byte b = byteArr[i];
			char ch = (char) b;
			//System.out.println(ch);
		}
		
		byteArr = new byte[charArr.length<<1];
		for (int i=0; i<charArr.length; i++) {
			int lsByte = charArr[i]&0xFF;
			int msByte = (charArr[i]>>8)&0xFF;
			byteArr[2*i+1] = (byte) lsByte;
			byteArr[2*i] = (byte) msByte;
		}
		
		for (int i=0; i<byteArr.length;) {
			char ch = (char) ((byteArr[i]<<8) + byteArr[i+1]);
			System.out.println(ch);
			i+=2;
		}
	}
}
