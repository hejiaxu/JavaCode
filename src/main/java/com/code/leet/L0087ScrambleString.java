package com.code.leet;

/*
Given a string s1,
we may represent it as a binary tree by partitioning it
to two non-empty substrings recursively.
 */
public class L0087ScrambleString {

    public boolean isScramble2(String s1, String s2) {
        int len = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        boolean[][][] record = new boolean[len][len][len];
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                for (int k = 0; k <= len - i; k++) {
                    if ( s1.substring(j, j + i).equals(s2.substring(k, k + i)) ) {
                        record[i - 1][j][k] = true;
                    } else {
                        for (int l = 1; l < i; l++) {
                            if (record[l - 1][j][k] && record[i - 1 - l][j + l][k + l]
                                    || (record[l - 1][j][k + i - l] && record[i - 1 - l][j + l][k])
                                    ) {
                                record[i - 1][j][k] = true;
                            }
                        }
                    }
                }
            }
        }
        return record[len - 1][0][0];
    }

    public boolean isScramble3(String s1, String s2) {
        int len = s1.length();
        if (s1.equals(s2)) {
            return true;
        }
        if (!isCoincide(s1, s2)) {
            return false;
        }

        for (int i = 1; i < len; i++) {
            String ss1i = s1.substring(0, i);
            String ss2i = s2.substring(0, i);
            String ss1l = s1.substring(i, len);
            String ss2l = s2.substring(i, len);
            String ss1x = s2.substring(len - i, len);
            String ss2x = s2.substring(0, len - i);
            if(isScramble3(ss1i, ss2i) && isScramble3(ss1l, ss2l) || (isScramble3(ss1i, ss1x) && isScramble3(ss1l, ss2x))) {
                return true;
            }
        }
        return false;
    }

    boolean isCoincide(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        if (l1 != l2) {
            return false;
        }
        int[] hash = new int[128];
        for (int i = 0; i < l1; i++) {
            hash[s1.charAt(i)]++;
            hash[s2.charAt(i)]--;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "aa";
        String s2 = "ab";
        boolean scramble = new L0087ScrambleString().isScramble(s1, s2);
        System.out.println(scramble);
    }

    //tricks
    int[] p = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53,
            59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131,
            137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
            283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373,
            379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457,
            461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557,
            563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641,
            643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733,
            739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827,
            829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929,
            937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    public boolean isScramble(String s1, String s2) {
        int l1=s1.length(), l2=s2.length();
        if(l1 != l2) {
            return false;
        }
        if(l1 <= 1) {
            return s1.equals(s2);
        }
        if(s1.equals(s2)) {
            return true;
        }
        long a = 1, b = 1, c = 1;
        for(int i = 0; i < l1; i++){
            if(i > 0 && a == b && isScramble(s1.substring(0, i), s2.substring(l2 - i)) && isScramble(s1.substring(i),s2.substring(0,l2 - i))) {
                return true;
            }
            if(i > 0 && a == c && isScramble(s1.substring(0, i),s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            a *= s1.charAt(i);
            b *= s2.charAt(l2-1-i);
            c *= s2.charAt(i);
//            a*=p[s1.charAt(i)-'A'];
//            b*=p[s2.charAt(l2-1-i)-'A'];
//            c*=p[s2.charAt(i)-'A'];
        }
        return false;
    }
}
