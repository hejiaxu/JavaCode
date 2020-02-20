package com.code.leet;

import java.util.*;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid.
Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).
 */
public class L0301RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }

    /*
    https://discuss.leetcode.com/topic/35045/java-2ms-dfs-solution-based-on-dietpepsi-s/7
     */
    public List<String> removeInvalidParentheses3(String s) {
        List<String> ans = new ArrayList<>();
        removeLeft(s, ans, new char[s.length()], 0, 0, 0);
        return ans;
    }

    private void removeLeft(String s, List<String> ans, char[] buf, int pos, int start, int last) {
        int p = start, b = 0;
        for (int i = start; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                ++b;
            } else if (s.charAt(i) == ')') {
                --b;
            }
            if (b <= 0) {
                p = i + 1;
            }
            if (b < 0) {
                for (int j = last; j <= i; ++j) {
                    if (s.charAt(j) == ')' && (j == last || s.charAt(j - 1) != ')')) {
                        s.getChars(last, j, buf, pos);
                        removeLeft(s, ans, buf, pos + j - last, i + 1, j + 1);
                    }
                }
                return;
            }
        }
        s.getChars(last, p, buf, pos);
        int rem = b + (last - pos); // total number of parentheses to remove, including already removed
        removeRight(s, ans, buf, buf.length - rem, buf.length - rem, s.length() - 1, s.length() - 1, p);
    }

    private void removeRight(String s, List<String> ans, char[] buf, int pos, int len,
                                    int start, int last, int p) {
        int b = 0;
        for (int i = start; i >= p; --i) {
            if (s.charAt(i) == ')') {
                ++b;
            } else if (s.charAt(i) == '(') {
                --b;
            }
            if (b < 0) {
                for (int j = last; j >= i; --j) {
                    if (s.charAt(j) == '(' && (j == last || s.charAt(j + 1) != '(')) {
                        s.getChars(j + 1, last + 1, buf, pos - (last - j));
                        removeRight(s, ans, buf, pos - (last - j), len, i - 1, j - 1, p);
                    }
                }
                return;
            }
        }
        s.getChars(p, last + 1, buf, pos - (last + 1 - p));
        ans.add(new String(buf, 0, len));
    }

    public List<String> removeInvalidParentheses2(String s) {
        List<String> r = new LinkedList <>();
        if (isValid(s)) {
            r.add(s);
            return r;
        }
        Set<String> set = new HashSet <>();
        set.add(s);
        Set <String> strings = removeInvalidParenthesesRecur(set);
        r.addAll(strings);
        return r;
    }

    private Set<String> removeInvalidParenthesesRecur(Set<String> set) {
        Set<String> r = new HashSet <>();
        while(!set.isEmpty() && r.isEmpty()) {

            for (String s : set) {
                if (isValid(s)) {
                    r.add(s);
                }
            }

            Set<String> nset = new HashSet <>();
            for (String s : set) {
                for (int i = 0; i < s.length(); i++) {
                    String s1 = s.substring(0, i) + s.substring(i + 1, s.length());
                    nset.add(s1);
                }
            }
            set = nset;
        }
        return r;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack <>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if(c == ')' || c == ']' || c == '}') {
                if (stack.empty()) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (c == ')' && pop != '('
                            || (c == ']' && pop != '[')
                            || (c == '}' && pop != '{')) {
                        return false;
                    }
                }
            }
        }

        return stack.empty();
    }





    public static void main(String[] args) {
        String s = "(()";
//        String s2 = s.substring(0, 0) + s.substring(0 + 1, s.length());
//        System.out.println(s2);
        List <String> strings = new L0301RemoveInvalidParentheses().removeInvalidParentheses(s);
        for (int i = 0; i < strings.size(); i++) {
            String s1 = strings.get(i);
            System.out.println(s1);
        }

    }
}
