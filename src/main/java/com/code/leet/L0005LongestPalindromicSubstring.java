/**
 *
 */
package com.code.leet;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *  
 *
 */
public class L0005LongestPalindromicSubstring {

    public static void main(String[] args) {
        // TODO

    }

    //70ms
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0, end = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 < end - start) {
                start = l + 1;
                end = r;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (r - l - 1 < end - start) {
                start = l + 1;
                end = r;
            }

        }
        return s.substring(start, end);
    }

    //149ms
    public String longestPalindrome2(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    //11ms
    public String longestPalindrome3(String s) {
        if (s == null) {
            return "";
        }
        char[] arr = s.toCharArray();
        int max = 0;
        int maxi = 0;
        int maxj = 0;

        for (int i = 0; i < arr.length; ) {
            int i1 = getFarestSameElementIndex(arr, i);
            int dist = getDistance(arr, i, i1);
            int index1 = i - dist;
            int index2 = i1 + dist;
            int l = index2 - index1;
            if (l > max) {
                max = l;
                maxi = index1;
                maxj = index2;
            }
            i = i1 + 1;
        }

        return s.substring(maxi, maxj + 1);
    }

    private int getDistance(char[] arr, int index1, int index2) {
        int i1 = index1 - 1;
        int i2 = index2 + 1;
        int dist = 0;
        while (i1 >= 0 && i2 < arr.length) {
            if (arr[i1] == arr[i2]) {
                dist++;
            } else {
                break;
            }
            i1--;
            i2++;
        }
        return dist;
    }

    private int getFarestSameElementIndex(char[] arr, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] != arr[index]) {
                return i - 1;
            }
        }
        return arr.length - 1;
    }


    private int lo, maxLen;

    //23ms
    public String longestPalindrome4(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}
// 通过动态规划，二维数组保存l->r是否是回文，l和r的相同，且l+1,r-1不存在或者也为回文，则l,r为回文
