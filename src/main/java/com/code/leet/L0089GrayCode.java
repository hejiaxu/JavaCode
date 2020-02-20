package com.code.leet;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class L0089GrayCode {
    public static void main(String[] args) {
        List<Integer> integers = new L0089GrayCode().grayCode(2);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
    public List<Integer> grayCode(int n) {
        LinkedList<Integer> last = new LinkedList();
        last.add(0);
        LinkedList<Integer> r = last;
        for (int i = 0; i < n; i++) {
            r = new LinkedList<>();
            for (Integer integer : last) {
                r.add(integer);
            }
            Iterator<Integer> rIterator = last.descendingIterator();
            while (rIterator.hasNext()) {
                Integer next = rIterator.next();
                next |= 1 << i;
                r.add(next);
            }
            last = r;
        }
        return r;
    }

}
