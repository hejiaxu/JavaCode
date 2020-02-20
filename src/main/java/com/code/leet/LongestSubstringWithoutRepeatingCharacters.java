/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Mar 28, 2017
 * 
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO 
		int result = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("tmmzuxt");
		System.out.println(result);

	}
	
	//46 ms
	public int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		int [] hash = new int [128];
		int tmpLen = 0;
		for(int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if (hash[ch]>0) {
				if (tmpLen > maxLen) {
					maxLen = tmpLen;
				}
				int pre = hash[ch];
				tmpLen -= pre;
				for(int j=0;j<128;j++){
					if (hash[j]>0) {
						hash[j] -= pre;
					}
				}
				
			}
				
			hash[ch] = ++tmpLen;
		}
		
		return maxLen>tmpLen?maxLen:tmpLen;
	}

}
