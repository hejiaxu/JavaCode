/**
 * 
 */
package com.code.leet;

import java.util.Arrays;

/**
 Write a function to find the longest common prefix string amongst an array of strings.
 */
public class L0014LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO 
		
	}
	
	//11ms
	public String longestCommonPrefix(String[] strs) {
        if (null == strs) {
			return null;
		}else if (strs.length < 1) {
			return "";
		}else if (strs.length == 1) {
			return strs[0];
		}
			
        StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < strs[0].length(); i++) {
			char tmp = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i || strs[j].charAt(i) != tmp) {
					return sBuilder.toString();
				}
			}
			sBuilder.append(tmp);
		}
        return sBuilder.toString();
    }
	
	
	//11ms
	public String longestCommonPrefix2(String[] strs) {
        StringBuilder result = new StringBuilder();
        
        if (strs!= null && strs.length > 0){
        
            Arrays.sort(strs);
            
            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();
            
            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }
        }
        return result.toString();

    }
	
	//9ms
	public String longestCommonPrefix3(String[] strs) {
	        if(strs == null || strs.length == 0)    return "";
	   String pre = strs[0];
	   int i = 1;
	   while(i < strs.length){
	       while(strs[i].indexOf(pre) != 0)
	           pre = pre.substring(0,pre.length()-1);
	       i++;
	   }
	   return pre;
	}
	
	//9ms
	 public String longestCommonPrefix4(String[] strs) {
	        if (strs.length < 1 || strs == null) {
	            return "";
	        }
	        if (strs.length == 1) {
	            return strs[0];
	        }
	        //find the shortest String
	        int shortest = 0;
	        int len = strs[0].length();
	        for (int i = 1; i < strs.length; i++) {
	            int curLen = strs[i].length();
	            if (curLen < len) {
	                len = curLen;
	                shortest = i;
	            }
	        }
	        //find the longest common prefix
	        String sub = strs[shortest];
	        for (int i = 0; i < strs.length; i++) {
	            while (strs[i].indexOf(sub) != 0) {
	                sub = sub.substring(0, sub.length()-1);
	            }
	        } 
	        return sub;
	    }
}
