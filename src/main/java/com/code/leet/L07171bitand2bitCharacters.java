package com.code.leet;

/*
We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

Example 1:
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
Example 2:
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
Note:

1 <= len(bits) <= 1000.
bits[i] is always 0 or 1.

 */
public class L07171bitand2bitCharacters {
    public static void main(String[] args) {
        int[] bits = {1, 1, 1, 0};
        boolean oneBitCharacter = new L07171bitand2bitCharacters().isOneBitCharacter(bits);
        System.out.println(oneBitCharacter);
    }
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (bits[i] == 0 || (i > 0 && bits[i - 1] == 1 && dp[i - 1] == true)) {
                dp[i + 1] = true;
            }
        }
        return bits[len - 1] == 0 && dp[len - 1];
    }
}
