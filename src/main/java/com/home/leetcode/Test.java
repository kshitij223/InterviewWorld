package com.home.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		char ch = ' ';
		//System.out.println((int) ch);
		String str="2";
//		System.out.println("abc \\\\ \\ \n \\n xyz");
		
		Map<String, String> tMap = new TreeMap<>();
		tMap.put("abc", "val1");
		tMap.put("rrr", "val1");
		tMap.put("bbb", "val1");
		tMap.put("ddd", "val1");
		tMap.put("ccc", "val1");
		
//		System.out.println(tMap.keySet());
		
		//System.out.println(str.substring(0,1));
		//System.out.println(str.substring(0,1));
//		System.out.println(1<<31);
//		System.out.println(Math.pow(2, 31));
//		System.out.println(""+Integer.MAX_VALUE);
//		System.out.println(-1 & (1<<2));
//		System.out.println(Byte.MIN_VALUE);
//		System.out.println(Byte.MAX_VALUE);
//		System.out.println(4&2);
//		System.out.println(Add(5,5));
//		System.out.println(Integer.MAX_VALUE+3);
//		System.out.println((2.4*Double.SIZE+3*Integer.SIZE) / Byte.SIZE);
//		System.out.println(3&1);
//		System.out.println(300>>1);
//		System.out.println(300/2);
//		int[][] arr = new int[][]{{3,2,1,0,4},{4,3,2,1,6}};
//		System.out.println(arr.length);
//		System.out.println(arr[0].length);
//		System.out.println(new Test().canJump(new int[]{3,2,1,0,4}));
		
//		System.out.println(-1>>10);
//		System.out.println(-1>>>1);
//		System.out.println(Math.pow(2, 31)-1);
//		System.out.println(Integer.MAX_VALUE == Math.pow(2, 31)-1);
//		System.out.println(-1<<2);
//		
//		Float f1=5f;
//		Float f2=f1;
//		System.out.println(f1==f2);
//		System.out.println(f1.floatValue()==f2.floatValue());
//		System.out.println(5f==5f);
//		
//		System.out.println(2>>0);
//		if(((5>>2) & 0x1) == 1) {
//			System.out.println("HI");
//		}
//		
//		/*
//		 * min+max=-1
//		 * max+1=min
//		 */
//		System.out.println(0x7fffffff);
//		System.out.println(Integer.MAX_VALUE+1);
//		System.out.println(Integer.MIN_VALUE + Integer.MIN_VALUE);
//		System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
//		System.out.println(Integer.MAX_VALUE + Integer.MIN_VALUE);
//		System.out.println(Math.abs(Integer.MIN_VALUE) > Math.abs(Integer.MAX_VALUE));
//		
//		System.out.println((1<<31) - 1);
//		System.out.println(0xff);
//		System.out.println(Math.pow(2,16)-1);
//		System.out.println((int)Character.MAX_VALUE);
//		System.out.println((int)Byte.MAX_VALUE);
		
		intTester();
		System.out.println(Long.MAX_VALUE);
		
	}
	
	private boolean isPalindrome(int n) {
        int intLen = (""+n).length();
        return n%(10^(intLen/2)) == n/(10^((int)Math.ceil(intLen/2)));
    }
	
	/*
	 * Construct 1024 integer out of a byte[]
	 */
	private static void intTester() {
		int i=1024;
		int numberOfBits=(int) (Math.log(i)/Math.log(2))+1;
		int bytes = numberOfBits/7;
		if(numberOfBits%7!=0) bytes++;
		
		byte[] arr = new byte[bytes];
		int byteIndex=0;
		while(i!=0) {
			//System.out.print((arr[0]&0x1) + " ");
			
			arr[byteIndex]=(byte) (i&127);
			i=i>>7;
			byteIndex++;
		}
		
		System.out.println(arr.length);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		
		System.out.println(arr[1]<<7 + arr[0]);
	}
	
	public List<Integer> subsets(int[] nums, int val) {
        List<Integer> valueList = new ArrayList<>();
        //Check number of ones.
        int bitPos=0;
        while(val!=0) {
            if(((val>>bitPos) & 0x1) == 1) {
                valueList.set(0, nums[bitPos]);
                bitPos++;
            }
        }
        return valueList;
    }
	
	public boolean canJump(int[] A) {
	    int max = 0;
	    for(int i=0;i<A.length;i++){
	        if(i>max) {return false;}
	        max = Math.max(A[i]+i,max);
	    }
	    return true;
	}
	
	static int Add(int x, int y)
    {
        // Iterate till there is no carry
        while (y != 0) 
        {
            // carry now contains common
            // set bits of x and y
            int carry = x & y;
 
            // Sum of bits of x and 
            // y where at least one 
            // of the bits is not set
            x = x ^ y;
 
            // Carry is shifted by 
            // one so that adding it 
            // to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

	public static int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        
        int uniqueIndex=0, prev=Integer.MIN_VALUE;
        for (int i=0; i<nums.length;) {
            if(prev>nums[i]) break;
            
            if (prev<nums[i]) {
                // new unique value. just accept and mark this as prev
                prev=nums[i];
                uniqueIndex++;
                i++;
            } else {
                // repetition
                if (!moveToEnd(nums, i)) break;
            }
        }
        return uniqueIndex;
    }
    
    private static boolean moveToEnd(int[] nums, int start) {
    	int temp = nums[start];
    	
    	boolean moved=false;
    	for (int i=start;i<nums.length-1;i++) {
    		if (nums[i]!=nums[i+1]) moved=true;
            nums[i]=nums[i+1];
        }
        nums[nums.length-1]=temp;
        return moved;
    } 
}
