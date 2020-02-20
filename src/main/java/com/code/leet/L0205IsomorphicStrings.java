/**
 * 
 */
package com.code.leet;

/**
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 */
public class L0205IsomorphicStrings {

	public static void main(String[] args) {
		// TODO 
		boolean isomorphic = isIsomorphic("fbaa", "fccc");
		System.out.println(isomorphic);
	}

	public static boolean isIsomorphic(String s, String t) {
		char tmp[] = new char [128];
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		for (int i = 0; i < sChar.length; i++) {
			char ci = sChar[i];
			char ti = tChar[i];
			if (tmp[ti] == 0) {
				tmp[ti] = ci;
			}else if (tmp[ti] != ci) {
				return false;
			}
		}
		for (int i = 1; i < tmp.length; i++) {
			for (int j = 0; j < i; j++) {
				if (tmp[i] == tmp[j] && tmp[i] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isIsomorphic3(String s, String t) {
		int[] m = new int[256];
		char[] s1Char = s.toCharArray();
		char[] s2Char = t.toCharArray();
		for (int i = 0; i < s1Char.length; i++) {
			if (m[s1Char[i]] != m[s2Char[i] + 128]) return false;
			m[s1Char[i]] = m[s2Char[i] + 128] = i + 1;
		}
		return true;
	}
}
