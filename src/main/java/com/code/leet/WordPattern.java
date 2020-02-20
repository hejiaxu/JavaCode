/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Mar 29, 2017
 * 
 */
public class WordPattern {

	public static void main(String[] args) {
		// TODO 
		WordPattern wordPattern = new WordPattern();
	}
	//1 ms
	public static boolean wordPattern(String pattern, String str) {
		String [] tmp = new String[26];    
		String[] split = str.split(" ");
		if (split.length!=pattern.length()) {
			return false;
		}
		for(int i=0;i<pattern.length();i++){
			if (tmp[pattern.charAt(i)-'a'] == null) {
				/*
				 * 考虑如果不同必须和之前的都不一样
				 */
				for(int j=0;j<26;j++){
					if (tmp[j]!=null && tmp[j].equals(split[i])) {
						return false;
					}
				}
				tmp[pattern.charAt(i)-'a']=split[i];
			}else{
				if (!tmp[pattern.charAt(i)-'a'].equals(split[i])) {
					return false;
				}
			}
		}
		
		return true;
    
	}

}
