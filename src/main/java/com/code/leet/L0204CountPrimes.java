package com.code.leet;

public class L0204CountPrimes {


    public static void main(String[] args) {
        int i = new L0204CountPrimes().countPrimes(499979);
        System.out.println(i);
    }

    public int countPrimes(int n) {
        boolean[] inPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
             if ((!inPrime[i])){
                count++;
             }
            for (int j = 2; j <= i && i <= n / 2 && (long)i * (long)j < (long)n; j++) {
                inPrime[i*j] = true;
            }
        }

        return count;
    }
}
