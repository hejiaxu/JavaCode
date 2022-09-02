package com.code.interview;

import java.util.Objects;

/*
There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

 

Example 1:

Input:
first = "pale"
second = "ple"
Output: True
Example 2:

Input:
first = "pales"
second = "pal"
Output: False

 */
public class LCCI0105OneAway {

    //"teacher"
    //"taches"
    public static void main(String[] args) {
        boolean b = new LCCI0105OneAway().oneEditAway("a", "ab");
        System.out.println(b);
    }
    public boolean oneEditAway(String first, String second) {
        if (Objects.equals(first, second)) {
            return true;
        }
        if (first == null || first.equals("")) {
            return oneEditAway(second, first);
        }

        if (second == null || second.equals("")) {
            return first.length() <= 1;
        }
        if (first.length() == second.length()) {
            return sameLenEquals(first, second);
        }

        if (first.length() < second.length()) {
            return oneEditAway(second, first);
        }

        if (first.length() - second.length() > 1) {
            return false;
        }

        return overLenEquals(first, second);
    }

    private boolean overLenEquals(String first, String second) {
        int count = 0;
        for (int i = 0, p = 0; i < first.length() && p < second.length(); i++) {
            if (first.charAt(i) != second.charAt(p)) {
                count++;
            } else {
                p++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean sameLenEquals(String second, String first) {
        int count = 0;
        for (int i = 0; i < second.length(); i++) {
            if (second.charAt(i) != first.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
