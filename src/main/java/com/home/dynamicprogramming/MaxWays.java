package com.home.dynamicprogramming;

public class MaxWays {

	public static void main(String[] args) {
		//System.out.println(count(15));
		count(15);
	}
	
	public static int count(int n)
	{
	    // table[i] will store count of solutions for
	    // value i.
	    int[] table = new int[n+1];
	    int i;
	 
	    // Base case (If given value is 0)
	    table[0] = 1;
	 
	    // One by one consider given 3 moves and update the table[]
	    // values after the index greater than or equal to the
	    // value of the picked move
	    for (i=3; i<=n; i++)
	       table[i] += table[i-3];
	    for (int f=0; f<=n; f++) {
	    	System.out.print(table[f]+" ");
	    }System.out.println();
	    for (i=5; i<=n; i++)
	       table[i] += table[i-5];
	    for (int f=0; f<=n; f++) {
	    	System.out.print(table[f]+" ");
	    }System.out.println();
	    for (i=10; i<=n; i++)
	       table[i] += table[i-10];
	 
	    for (int f=0; f<=n; f++) {
	    	System.out.print(table[f]+" ");
	    }
	    return table[n];
	}

}
