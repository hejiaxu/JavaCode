package com.code.interview;


/*
Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

 

Example1:

Input: "tactcoa"
Output: true（permutations: "tacocat"、"atcocta", etc.）

 */
public class LCCI0104PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        boolean[] bucket = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
          bucket[s.charAt(i)] = !bucket[s.charAt(i)];
        }
        int count = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }

        return true;
    }
}
