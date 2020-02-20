/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Jun 9, 2017
 * 
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO 

	}
	
	//27ms
	public String minWindow(String s, String t) {
		int hashT[] = new int[128];
		int hashS[] = new int[128];
		for(int i=0;i<t.length();i++){
			hashT[t.charAt(i)]++;
		}
		int l=0,r=0,min=Integer.MAX_VALUE,minL=0,minR=0;
		while(r<s.length()||isOk(hashT,hashS)){
			if (isOk(hashT,hashS)) {
				if (r-l<min) {
					min=r-l;
					minL=l;
					minR=r;
				}
				hashS[s.charAt(l)]--;
				l++;
			}else {
				hashS[s.charAt(r)]++;
				r++;
			}
		}
		return s.substring(minL, minR);
    }
	public boolean isOk(int hashT[],int hashS[]){
		for (int i = 0; i < hashT.length; i++) {
			if (hashT[i]!=0&&hashT[i]>hashS[i]) {
				return false;
			}
		}
		return true;
	}
}
