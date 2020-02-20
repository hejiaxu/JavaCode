/**
 * 
 */
package com.code.leet;

/**
 * Jiaxu
 * Oct 27, 2016
 * 
 */
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO 
		ValidPalindrome bean = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		boolean palindrome = bean.isPalindrome2(s);
		System.out.println(palindrome);
//		System.err.println(Character.getNumericValue('z'));
//		System.out.println('A'>'a');
	}
	
	//Runtime: 7 ms
	public boolean isPalindrome(String s) {
		char[] charArray = s.toCharArray();
		int head = 0,tail = charArray.length-1;
		
		while(head < tail){
			while(head < tail && !Character.isLetterOrDigit(charArray[head])){
				head++;
			}
			while(head < tail && !Character.isLetterOrDigit(charArray[tail])){
				tail--;
			}
			if (Character.toUpperCase(charArray[head]) != Character.toUpperCase(charArray[tail])) {
				return false;
			}
			head ++;
			tail --;
		}
		return true;
	}
	//Runtime: 7 ms
	public boolean isPalindrome2(String s) {
		char[] charArray = s.toCharArray();
		int head = 0,tail = charArray.length-1;
		
		while(head < tail){
			if (!Character.isLetterOrDigit(charArray[head])){
				head++;
			}else if (!Character.isLetterOrDigit(charArray[tail])){
				tail--;
			}else if (Character.toUpperCase(charArray[head]) != Character.toUpperCase(charArray[tail])) {
				return false;
			}else {
				head++;
				tail--;
			}
			
		}
		return true;
	}
	
	public char getChar(String s, int index) {
        char c = s.charAt(index);
        
        if (c >= '0' && c <= '9')
            return c;
            
        if (c >= 'a' && c <= 'z')
            return c;
            
        if (c >= 'A' && c <= 'Z')
            return (char)(c + 'a' - 'A');
            
        return 0;
    }
    
	//5ms
    public boolean isPalindrome3(String s) {
        int len = s.length();
        if (len <= 1)
            return true;
        
        int l = 0;
        int r = len - 1;
        char cl, cr;
        
        while (l < len && r >= 0) {
            cl = getChar(s, l);
            while (cl == 0 && l < len - 1) {
                l++;
                cl = getChar(s, l);
            }
            if (cl == 0)
                break;
            
            cr = getChar(s, r);
            while (cr == 0 && r > 0) {
                r--;
                cr = getChar(s, r);
            }
            if (cr == 0)
                break;

            if (cl != cr)
                return false;
                
            if (l >= r - 1)
                break;

            l++;
            r--;
        }
        
        return true;
    }
    
    
    //4ms
    public boolean isPalindrome4(String s) {
        char[] ss = s.toCharArray();
        for (int i = 0, j = ss.length - 1; i < j; i++, j--) {
            if ((ss[i] < 'A' || (ss[i] > 'Z' && ss[i] < 'a') || ss[i] > 'z') && (ss[i] < '0' || ss[i] > '9')) {
                j++;
                continue;
            }
            if ((ss[j] < 'A' || (ss[j] > 'Z' && ss[j] < 'a') || ss[j] > 'z') && (ss[j] < '0' || ss[j] > '9')) {
                i--;
                continue;
            }
            if ('A' <= ss[i] && ss[i] <= 'Z') {
                ss[i] += 32;
            }
            if ('A' <= ss[j] && ss[j] <= 'Z') {
                ss[j] += 32;
            }
            if (ss[i] != ss[j]) {
                return false;
            }
        }
        return true;
    }
    
    //40ms
    public boolean isPalindrome5(String s) {
        s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}