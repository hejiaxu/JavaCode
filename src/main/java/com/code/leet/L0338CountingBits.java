/**
 * 
 */
package com.code.leet;

/**
 Given a non negative integer number num.
 For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation
 and return them as an array.
 */
public class L0338CountingBits {

	public static void main(String[] args) {
		// TODO 
		L0338CountingBits bean = new L0338CountingBits();
		int[] countBits = bean.countBits2(15);
		for (int i = 0; i < countBits.length; i++) {
			System.out.println(countBits[i]);
		}
		
	}

    public int[] countBits2(int num) {
        int [] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + i & 1;
        }
        return result;
    }
}
