/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 15, 2017
 * 
 */
public class PermutationinString {

	public static void main(String[] args) {
		// TODO 

	}
	
	//21ms
	public boolean checkInclusion(String s1, String s2) {
		char [] c1 = s1.toCharArray(),c2 = s2.toCharArray();
		int len1 = c1.length,len2 = c2.length;
		if (len1>len2) {
			return false;
		}
		int[] tmp1 = new int[256];
		for (int i = 0; i <len1; i++) {
			tmp1[c1[i]]++;
			tmp1[c2[i]+128]++;
		}
		for (int j = len1; j < len2; j++) {
			if (check(tmp1)) {
				return true;
			}
			tmp1[c2[j]+128]++;
			tmp1[c2[j-len1]+128]--;
		}
        return false;
    }
	private boolean check(int[] tmp1) {
		// TODO 
		for (int i = 0; i < 128; i++) {
			if (tmp1[i]!=tmp1[i+128]) {
				return false;
			}
		}
		return true;
	}
	//21ms
	public boolean checkInclusion2(String s1, String s2) {
        int[] count = new int[128];
        for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
        for(int l = 0, r = 0; r < s2.length(); r++) {
            if (++count[s2.charAt(r)] > 0)
                while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
            else if ((r - l + 1) == s1.length()) return true;
        }
        return s1.length() == 0;
    }
}
