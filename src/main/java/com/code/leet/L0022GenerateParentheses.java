package com.code.leet;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given n pairs of parentheses,
write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class L0022GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        LinkedList<StringBuilder> record = new LinkedList <>();
        record.add(new StringBuilder());
        for (int i = 0; i < n; i++) {

            int size = record.size();
            for (int j = 0; j < size; j++) {

                StringBuilder stringBuilder =  record.get(j);
                stringBuilder.append('(');
                if (i != n -1) {
                    int length = stringBuilder.length();
                    for (int k = 0; k < (2 * (i + 1) - length); k++) {
                        stringBuilder = new StringBuilder(stringBuilder);
                        stringBuilder.append(')');
                        record.add(stringBuilder);
                    }
                }
            }
        }

        LinkedList<String> r = new LinkedList <String>();
        for (int i = 0; i < record.size(); i++) {
            StringBuilder stringBuilder = record.get(i);
            for (int j = stringBuilder.length(); j < n * 2; j++) {
                stringBuilder.append(')');
            }
            r.add(stringBuilder.toString());
        }
        return r;
    }

    public static void main(String[] args) {
        List <String> strings = new L0022GenerateParentheses().generateParenthesis(3);
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
        if(open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append("(");
            helper(res, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if(close < open) {
            sb.append(")");
            helper(res, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }

    public List<String> generateParenthesis4(int n) {
        ArrayList<String> m=new ArrayList<>();
        generate(m, "", n, n);
        return m;
    }

    public void generate(ArrayList m, String s, int l, int r){
        if(l == 0 && r == 0){
            m.add(s);
            return;
        }
        if(l > 0) generate(m, s + "(",  l - 1,  r);
        if(r > l) generate(m, s + ")",  l,  r - 1);
    }

    public List<String> generateParenthesis5(int n) {
        List<String> res = new ArrayList<>();
        char[] perm = new char[n * 2];
        perms(n, n, perm, 0, res);
        return res;
    }

    private void perms(int open, int close, char[] perm, int i, List<String> res) {
        if (i == perm.length) {
            res.add(new String(perm));
            return;
        }
        if (open > 0 && close >= open) {
            perm[i] = '(';
            perms(open - 1, close, perm, i+1, res);
        }
        if (close > 0) {
            perm[i] = ')';
            perms(open, close - 1, perm, i+1, res);
        }
    }
}

/*
此题不适合使用dp算法,因为在递归过程中并没有重复运算，dp不能提升效率
 */