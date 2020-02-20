package com.code.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

Given a string that contains only digits 0-9 and a target value,
return all possibilities to add binary operators (not unary) +, -, or * between the digits
so they evaluate to the target value.
Examples:
"123", 6 -> ["1+2+3", "1*2*3"]
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
 */
public class L0282ExpressionAddOperators {
    public static void main(String[] args) {
        String num = "2147483648";
        int target = -2147483648;

        List<String> strings = new L0282ExpressionAddOperators().addOperators(num, target);
        for (String str: strings) {
            System.out.println(str);
        }
    }

    public List<String> addOperators(String num, int target) {
        List<String> r = new LinkedList<>();
        if (num == null || num.equals("")) {
            return r;
        }
        char[] numChar = num.toCharArray();
        char[] operArr = new char[num.length() - 1];
        char[] opers = {'+', '-', '*', '_'};
        dfs(r, numChar, 0, target, operArr, opers);
        return r;
    }

    private void dfs(List<String> r, char[] numChar, int pos, int target, char[] operArr, char[] opers) {
        if (pos == operArr.length) {
            Queue<Long> numQueue = new LinkedList<>();
            Queue<Character> opQueue = new LinkedList<>();
            for (int i = 0; i < numChar.length; i++) {
                numQueue.offer((long)(numChar[i] - '0'));
            }
            for (int i = 0; i < operArr.length; i++) {
                opQueue.offer(operArr[i]);
            }

            Queue<Character> nQueue = new LinkedList<>();
            long num = numQueue.poll();
            while(!opQueue.isEmpty()) {
                Character poll = opQueue.poll();
                if (poll == '_' && num != 0) {
                    num = num * 10 + numQueue.poll();
                } else {
                    numQueue.offer(num);
                    num = numQueue.poll();
                    nQueue.offer(poll);
                }
            }
            numQueue.offer(num);
            Queue<Character> tmp = opQueue;
            opQueue = nQueue;
            nQueue = tmp;
            num = numQueue.poll();
            while(!opQueue.isEmpty()) {
                Character poll = opQueue.poll();
                if (poll == '*') {
                    num = num * numQueue.poll();
                } else if (poll == '/') {
                    num = num / numQueue.poll();
                } else {
                    numQueue.offer(num);
                    num = numQueue.poll();
                    nQueue.offer(poll);
                }
            }
            numQueue.offer(num);
            opQueue = nQueue;
            num = numQueue.poll();
            while(!opQueue.isEmpty()) {
                Character poll = opQueue.poll();
                if (poll == '+') {
                    num = num + numQueue.poll();
                } else if (poll == '-') {
                    num = num - numQueue.poll();
                }
            }
            if (numQueue.isEmpty() && num == target) {
                StringBuilder sb = new StringBuilder();
                char pre = '_';
                for (int i = 0; i < numChar.length; i++) {
                    if (numChar[i] != '0' || i == operArr.length || operArr[i] != '_' || (pre >= '0' && pre <= '9')) {
                        sb.append(numChar[i]);
                        pre = numChar[i];
                    }
                    if (i < operArr.length && operArr[i] != '_') {
                        sb.append(operArr[i]);
                        pre = operArr[i];
                    }
                }
                r.add(sb.toString());
            }
            return;
        }

        for (char oper : opers) {
            operArr[pos] = oper;
            dfs(r, numChar, pos + 1, target, operArr, opers);
        }
    }

    public List<String> addOperators2(String num, int target) {
        char[] digit = num.toCharArray(), path = new char[num.length() * 2];
        List<String> ans = new ArrayList();
        long pureNum = 0;
        for (int i = 0; i < digit.length; i++) {
            pureNum = pureNum * 10 + (long)(digit[i] - '0');
            path[i] = digit[i];
            dfs(i + 1, i + 1, 0, pureNum, path, digit, target, ans);
            if (pureNum == 0) break; // not allow number with 0 prefix, except zero itself;
        }
        return ans;
    }

    private void dfs(int ip, int id, long toAdd, long toMult, char[] path, char[] digit, int target, List<String> ans) {
        if (id == digit.length && toAdd + toMult == target) {
            ans.add(String.valueOf(path, 0, ip));
            return;
        }
        long pureNum = 0;
        for (int i = 0; id + i < digit.length; i++) {
            pureNum = pureNum * 10 + (long)(digit[id + i] - '0');
            path[ip + i + 1] = digit[id + i];
            path[ip] = '+';
            dfs(ip + i + 2, id + i + 1, toAdd + toMult, pureNum, path, digit, target, ans);
            path[ip] = '-';
            dfs(ip + i + 2, id + i + 1, toAdd + toMult, -pureNum, path, digit, target, ans);
            path[ip] = '*';
            dfs(ip + i + 2, id + i + 1, toAdd, toMult * pureNum, path, digit, target, ans);
            if (pureNum == 0) break; // not allow number with 0 prefix, except zero itself;
        }
    }
}
