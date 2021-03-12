package com.code.lcof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by hejiaxu on 2021/2/19
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 */
public class Offer38Permutation {
    public static void main(String[] args) {

        String[] strings = new Offer38Permutation().permutation("aaab");
        for (String s : strings) {
            System.out.println(s);
        }
    }


    public String[] permutation1(String s) {
        char[] chars = s.toCharArray();
        List<String> r = new LinkedList<>();

        dfs(chars, 0, r);
        return r.toArray(new String[0]);
    }

    /**
     * 分别通过记录每一个数每一层已经使用过数，逐级深度遍历
     * 可以忽略掉重复数字的影响
     */
    private void dfs(char[] chars, int pos, List<String> r) {
        if (pos == chars.length) {
            r.add(new String(chars));
        }

        Set<Character> sets = new HashSet<>();

        for (int i = pos; i < chars.length; i++) {
            char aChar = chars[i];
            if (sets.contains(aChar)) continue;
            sets.add(aChar);
            swap(chars, pos, i);
            dfs(chars, pos + 1, r);
            swap(chars, pos, i);
        }
    }


    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> r = new LinkedList<>();
        Arrays.sort(chars);
        dfs(chars, new boolean[chars.length], r, new char[chars.length], 0);
        return r.toArray(new String[0]);
    }

    /**
     * 标记已经被选中的数，在回溯时清除标记，通过标记去重
     * 只要保证相对顺序选择，即可保证不重复
     *
     */
    private void dfs(char[] chars, boolean[] used, List<String> r, char[] tmp,  int pos) {
        if (pos == chars.length) {
            r.add(new String(tmp));
        }
        for (int i = 0; i < chars.length; i++) {

            if (used[i] || (i < chars.length - 1 && chars[i] == chars[i + 1] && used[i + 1])) {
                continue;
            }
            used[i] = true;
            tmp[pos] = chars[i];
            dfs(chars, used, r, tmp, pos + 1);
            used[i] = false;
        }


    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
