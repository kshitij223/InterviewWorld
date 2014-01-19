package com.home.binary;

public class DecimalToBinary {

	public static void main(String[] args) {
		double num = 0.625;
		StringBuilder binary = new StringBuilder();
		binary.append(".");
		while (num > 0) {
			if (binary.length() > 32) {
				System.out.println("ERROR");
			}
			double r = num*2;
			if (r>=1) {
				binary.append(1);
				num = r-1;
			}
			else {
				binary.append(0);
				num = r;
			}
		}
		System.out.println(binary.toString());
	}
}
