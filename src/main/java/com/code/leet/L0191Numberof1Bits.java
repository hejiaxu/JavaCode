package com.code.leet;

public class L0191Numberof1Bits {

    public int hammingWeight(int n) {

        int count = 0;
        long num = n;
        if ( n < 0 ) {
            num = n + Integer.MAX_VALUE + 1;
            count++;
        }
        while(num > 0) {
            count++;
            num = num & num - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new L0191Numberof1Bits().hammingWeight(Integer.MIN_VALUE);
        System.out.print(i);
    }
}
