package com.code.leet;

import java.util.*;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 */
public class L0131PalindromePartitioning {
    public static void main(String[] args) {
        String str = "aab";
        List<List<String>> partition = new L0131PalindromePartitioning().partition2(str);
        for (List<String> list : partition) {
            for (String string : list) {
                System.out.print(string);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    Map<String, List<List<String>>> map = new HashMap<>();
    public List<List<String>> partition(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<List<String>> r = new LinkedList<>();
        if (isPalindrome(s)) {
            List<String> item = new LinkedList<>();
            item.add(s);
            r.add(item);
        }
        for (int i = 1; i < s.length(); i++) {
            String sub = s.substring(0, i);
            if (isPalindrome(sub)) {
                for (List<String> list : partition(s.substring(i, s.length()))) {
                    List<String> listClone = new LinkedList<>(list);
                    listClone.add(0, sub);
                    r.add(listClone);
                }
            };
        }
        map.put(s, r);
        return r;
    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition2(String s) {
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<String>());

        boolean[][] p = new boolean[len][len];
        for (int i = 0; i < s.length(); i++) {
            result[i + 1] = new ArrayList<>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i - left <= 1 || p[left + 1][i - 1])) {
                    p[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : result[left]) {
                        List<String> ri = new ArrayList<>(r);
                        ri.add(str);
                        result[i + 1].add(ri);
                    }
                }
            }
        }
        return result[len];
    }
}
