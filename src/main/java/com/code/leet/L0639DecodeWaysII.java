package com.code.leet;


/*
A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*',
which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*',
return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.

 */
public class L0639DecodeWaysII {
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        long[] dp = new long[length + 1];
        dp[0] = 1;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '*') {
                dp[i + 1] += dp[i] * 9;
            } else if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            if (i > 0) {
                if (s.charAt(i - 1) == '*') {
                    if (s.charAt(i) == '*') {
                        dp[i + 1] += dp[i - 1] * 15;
                    } else if (s.charAt(i) <= '6') {
                        dp[i + 1] += dp[i - 1] * 2;
                    } else {
                        dp[i + 1] += dp[i - 1];
                    }
                } else if (s.charAt(i - 1) == '1') {
                    if (s.charAt(i) == '*') {
                        dp[i + 1] += dp[i - 1] * 9;
                    } else {
                        dp[i + 1] += dp[i - 1];
                    }
                } else if (s.charAt(i - 1) == '2') {
                    if (s.charAt(i) == '*') {
                        dp[i + 1] += dp[i - 1] * 6;
                    } else if (s.charAt(i) <= '6') {
                        dp[i + 1] += dp[i - 1];
                    }
                }

            }
            dp[i + 1] %= 1000000007;

        }
        return (int)dp[length];
    }
}
