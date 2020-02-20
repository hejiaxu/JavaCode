package com.code.leet;

/*
Given an integer, write an algorithm to convert it to hexadecimal.
For negative integer, two’s complement method is used.

Note:

All letters in hexadecimal (a-f) must be in lowercase.
The hexadecimal string must not contain extra leading 0s. If the number is zero,
it is represented by a single zero character '0';
otherwise, the first character in the hexadecimal string will not be the zero character.
The given number is guaranteed to fit within the range of a 32-bit signed integer.
You must not use any method provided by the library
which converts/formats the number to hex directly.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"

 */
public class L0405ConvertaNumbertoHexadecimal {
    public static void main(String[] args) {
        String s = new L0405ConvertaNumbertoHexadecimal().toHex2(-1);
        System.out.println(s);
    }
    public String toHex(int num) {
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        boolean nonZero = false;
        for (int i = 28; i >= 0 ; i -= 4) {
            char c = hex[(num >>> i) & 0xf];
            if (c == '0' && !nonZero) {
                continue;
            }
            sb.append(c);
            nonZero = true;
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.toString();
    }

    public String toHex2(int num) {
        return Integer.toUnsignedString(num, 16);
    }


}
