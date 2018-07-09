package com.home.leetcode;

/*
3
2
Ben Google
Google Uber
Ben Yahoo


Output:
Google
 Uber
Ben
 Yahoo
  Uber

Suppose the input data were structured like this
[
    [NewWorldTrust, Google]   
    [Ben, NewWorldTrust]
    [Ben, SeaWorld]
    [Ben, Yahoo]
    [NewWorldTrust, Apple]
    [ShaneHoldings, Box]
    [NewWorldTrust, Yahoo]
]
The first element tells us that the New World Trust owns Google and the second element tells us that Ben owns the New World Trust. The output, which should be printed to STDOUT, should look like
Ben
 NewWorldTrust
  Google
  Apple
  Yahoo
 SeaWorld 
 Yahoo
ShaneHoldings
 Box
 
Each level of ownership is printed out with an extra space in front of the line relative to its parent level. The top level owners (Ben and Shane Holdings) are printed out with no indentation. You can assume that there are no ownership cycles. 

*/
import java.util.*;

class Container {
    String name;
    boolean isRoot=true;
    List<Container> inner = new ArrayList<>();
    List<String> children = new ArrayList<>();
}

public class Adeppar {

	public static void main(String...strings) {
		String[][] ownershipData = {
									{"NewWorldTrust", "Google"},   
		                            {"Ben", "NewWorldTrust"},
		                            {"Ben", "SeaWorld"},
		                            {"Ben", "Yahoo"},
		                            {"NewWorldTrust", "Apple"},
		                            {"ShaneHoldings", "Box"},
		                            {"NewWorldTrust", "Yahoo"}
		                            };
		printOwnership(ownershipData);
			
	}
	
    /*
     * Complete the printOwnership function below.
     */
    static void printOwnership(String[][] ownershipData) {
        
        Map<String, Container> compCache = new HashMap<>();
        boolean[] visited = new boolean[ownershipData.length];
        
        for (int i=0; i<ownershipData.length; i++) {
            if(!visited[i]) {
                ownerShipHelper(ownershipData, visited, compCache, ownershipData[i][0]);
            } else {
                //skip
            }
        }
        
        // Results will be stored in compCache
        for (String key: compCache.keySet()) {
        	if (compCache.get(key).isRoot) {
        		System.out.print(compCache.get(key).name+"\n");
        		print(compCache.get(key), " ");
        	}
        }

    }
    
    private static void print(Container cont, String space) {
        if (!cont.children.isEmpty()) {
            // yahoo, seaworld
            for (String str: cont.children) {
                System.out.print(space+str+"\n");
            }
        }
        
        if (!cont.inner.isEmpty()) {
            //newWorld
            for (Container innerCont: cont.inner) {
            	System.out.print(space+innerCont.name+"\n");
                print(innerCont, space+" ");
            }
        }
    }
    
    private static Container ownerShipHelper(String[][] ownershipData, boolean[] visited, Map<String, Container> compCache, String key) {
        if (ownershipData==null || ownershipData.length==0) return null;
        if (key==null) return null;
        
        Container cont = null;
        for (int i=0; i<ownershipData.length; i++) {
            
            if (ownershipData[i][0].equals(key) && !visited[i]) {
                if (compCache.containsKey(key)) {
                    cont = compCache.get(key);
                } else {
                    cont = new Container();
                    cont.name = key;
                    compCache.put(key, cont);
                }
                visited[i] = true;
                Container child = null;
                if (compCache.containsKey(ownershipData[i][1])) {
                	child = compCache.get(ownershipData[i][1]);
                } else {
                	child = ownerShipHelper(ownershipData, visited, compCache, ownershipData[i][1]);
                }
                if (child!=null) {
                    // The second part is an owner
                    cont.inner.add(child);
                    child.isRoot=false;
                } else {
                    cont.children.add(ownershipData[i][1]);
                }
            } else {
                // already processed the key or not an owner
            }
        }
        
        return cont;
    }
}

