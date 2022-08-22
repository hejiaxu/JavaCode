/**
 *
 */
package com.code.leet;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *  
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 *
 */
public class L0006ZigZagConversion {

    public static void main(String[] args) {
        // TODO
        String convert = convert("ABC", 3);
        System.out.println(convert);
    }

    //43ms
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[] c = s.toCharArray();
        char[] r = new char[c.length];
        int k = 0;
        for (int j = 0; j < numRows; j++) {
            if (j == 0 || j == numRows - 1) {
                for (int i = j; i < c.length; i += 2 * numRows - 2) {
                    r[k] = c[i];
                    k++;
                }
            } else {
                for (int l = j; l < c.length; l += 2 * numRows - 2) {
                    r[k] = c[l];
                    k++;
                    int m = l + 2 * numRows - 2 - l % (2 * numRows - 2) * 2;
                    if (m < c.length) {
                        r[k] = c[m];
                        k++;
                    }

                }
            }
        }

        return String.valueOf(r);
    }

    //43ms
    public static String convert2(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        char[] c = s.toCharArray();
        StringBuilder sBuilder = new StringBuilder();
        for (int j = 0; j < numRows; j++) {
            if (j == 0 || j == numRows - 1) {
                for (int i = j; i < c.length; i += 2 * numRows - 2) {
                    sBuilder.append(c[i]);
                }
            } else {
                for (int l = j; l < c.length; l += 2 * numRows - 2) {
                    sBuilder.append(c[l]);
                    int m = l + 2 * numRows - 2 - l % (2 * numRows - 2) * 2;
                    if (m < c.length) {
                        sBuilder.append(c[m]);
                    }

                }
            }
        }
        return sBuilder.toString();
    }


    //60ms
    public String convert3(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] sb = new StringBuilder[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

}
