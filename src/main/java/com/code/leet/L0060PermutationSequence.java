/**
 *
 */
package com.code.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p>
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class L0060PermutationSequence {

    public static void main(String[] args) {
        // TODO
        String permutation = getPermutation(2, 2);
        System.out.println(permutation);
    }


    //15ms
    public static String getPermutation(int n, int k) {
        StringBuilder sBuilder = new StringBuilder();
        ArrayList<Integer> set = new ArrayList<>();
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= i + 1;
            set.add(i + 1);
        }
        getPermutationRecur2(sBuilder, set, n, (k - 1) % sum, sum);
        return sBuilder.toString();
    }

    public static void getPermutationRecur2(StringBuilder sBuilder, ArrayList<Integer> set, int n, int k, int sum) {
        int total = sum / n, t = k / total;
        Integer integer = set.get(t);
        sBuilder.append(integer);
        set.remove(t);
        if (n > 1) getPermutationRecur2(sBuilder, set, n - 1, k % total, total);
    }

    //17ms
    public String getPermutation2(int n, int k) {
        List<Integer> nums = new ArrayList();
        int[] factorial = new int[n + 1];
        int f = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
            factorial[i] = f;
            nums.add(i);
        }
        return dfs(new StringBuilder(), nums, factorial, n, k - 1);
    }

    private String dfs(StringBuilder sb, List<Integer> nums, int[] f, int n, int k) {
        if (nums.size() == 0) return sb.toString();
        int i = k / f[n - 1];
        sb.append(nums.get(i));
        nums.remove(i);
        return dfs(sb, nums, f, n - 1, k - i * f[n - 1]);
    }
}
