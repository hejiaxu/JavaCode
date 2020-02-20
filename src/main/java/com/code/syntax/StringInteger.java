/**
 * 
 */
package com.code.syntax;

/**
 * Jiaxu
 * Mar 14, 2017
 * 
 */
public class StringInteger {

	public static void main(String[] args) {
		// TODO 
		String str = strAdd("3213123", "8894729847");
		System.out.println(str);
		String str1 = strAdd("123", "887");
		System.out.println(str1);
	}
	
	public static String strAdd(String str1, String str2){
		int str1Len = str1.length(),str2Len = str2.length();
		if (str1Len< str2Len) {
			return strAdd(str2, str1);
		}
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for(int i=str2Len-1;i>=0;i--){
			int a1 = str1.charAt(str1Len-str2Len+i) - '0';
			int a2 = str2.charAt(i) - '0';
			int a3 = a1 + a2;
			if (carry>0) {
				a3 +=1;
			}
			if (a3>9) {
				carry = 1;
				a3 -=10;
			}else {
				carry = 0;
			}
			sb.append(a3);
		}
		for(int j=str1Len-str2Len-1;j>=0;j--){
			int a1 = str1.charAt(j) - '0';
			if (carry > 0) {
				a1+=1;
			}
			
			if (a1 > 9) {
				a1 -= 10;
				carry = 1;
			}else {
				carry = 0;
			}
			sb.append(a1);
		}
		if (carry == 1) {
			sb.append(1);
		}
		return sb.reverse().toString();
	}
}
