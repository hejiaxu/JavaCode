package com.code.leet;

import java.util.LinkedList;
import java.util.List;

/*
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number,
including the bounds if possible.
 */
public class L0728SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> r = new LinkedList <>();
        for (int i = left; i <= right; i++) {
            if (isDN(i)) {
                r.add(i);
            }
        }
        return r;
    }

    private boolean isDN(int i) {
        if (i == 0) {
            return false;
        }
        int tmp = i;
        while(tmp > 0) {
            int e = tmp % 10;
            if (e == 0 || (i != i / e * e)) {
                return false;
            }
            tmp = tmp / 10;
        }
        return true;
    }
}
