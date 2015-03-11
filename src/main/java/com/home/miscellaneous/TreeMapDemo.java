package com.home.miscellaneous;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

	   public static void main(String args[]) {
	      // Create a hash map
	      TreeMap tm = new TreeMap();
	      // Put elements to the map
	      tm.put("Zara", new Double(3434.34));
	      tm.put("Mahnaz", new Double(123.22));
	      tm.put("Ayan", new Double(1378.00));
	      tm.put("Daisy", new Double(99.22));
	      tm.put("Qadir", new Double(-19.08));
	      
	      Set<String> keySet = tm.keySet();
	      for (String str: keySet) {
	    	  System.out.print(str + " " + tm.get(str));
	    	  System.out.println();
	      }
	   }
	   
	   public static void ab(final int abc) throws Exception {
		   final TreeMapDemo k = new TreeMapDemo();
	   }
	}