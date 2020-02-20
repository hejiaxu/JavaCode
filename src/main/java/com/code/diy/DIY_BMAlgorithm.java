package com.code.diy;

public class DIY_BMAlgorithm {
    public static void main(String[] args) {
        String haystack = "thisieexample";
        String needle = "example";
        int i = new DIY_BMAlgorithm().strStr(haystack, needle);
        System.out.println(i);
    }


    public int strStr(String haystack, String needle)
    {
        if(haystack == null || needle==null || needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }

        int M = haystack.length();
        int N = needle.length();

        int bcShift[] = new int[256];
        for(int i = 0; i < 256; i++){
            bcShift[i] = N;
        }
        for(int i = 0; i < N; i++) {
            bcShift[needle.charAt(i)] = N - 1 - i;
        }
        int[] suffix = new int[N];
        suffix[N - 1] = N;
        for(int i = N - 2; i >= 0; i--) {
            int j = i;
            while(j >= 0 && needle.charAt(j) == needle.charAt(N - 1 + i - j)) {
                --j;
            }
            suffix[i] = i - j;
        }

        int[] gsShift = new int[N];
        for (int i = 0; i < N; i++) {
                gsShift[i] = N;
        }
        for (int i = N - 1; i >= 0; i--) {
            if (suffix[i] == i + 1) {
                for (int j = 0; j < N - 1 - i; j++) {
                    if (gsShift[j] == N) {
                        gsShift[j] = N - 1 - i;
                    }
                }
            }
        }

        int i,j;
        int skip = 0;
        for(i = 0; i <= M - N; i +=  skip)
        {
            skip = 0;
            for(j = N - 1; j >= 0; j--)
            {
                if(needle.charAt(j) != haystack.charAt(i + j))
                {
                    skip = Math.max(bcShift[haystack.charAt(j + i)], 0);
                    break;
                }
            }
            if(skip == 0) {
                return i;
            }
        }
        return -1;
    }
}
