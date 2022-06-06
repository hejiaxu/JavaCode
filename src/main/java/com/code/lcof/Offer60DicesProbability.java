package com.code.lcof;

/**
 * Created by hejiaxu on 2021/2/19
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *  
 *
 * 限制：
 *
 * 1 <= n <= 11
 *
 */
public class Offer60DicesProbability {

    // miss
    /**
     * 1.暴力:
     * 2.dp
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 2};
        double[] r = new Offer60DicesProbability().dicesProbability(2);

        System.out.println(r[0]);
    }


    /**
     * 1.初始化dp数组
     * 2.dp[n + 1] = sum(dp[n] + x)
     */
    public double[] dicesProbability(int n) {
        double[] dp = new double[]{1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 6.0};
        while (n-- > 1) {
            double[] tmp = new double[dp.length + 5];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < 6; j++) {
                    tmp[i + j] += dp[i] / 6.0;
                }
            }

            dp = tmp;
        }
        return dp;
    }

}
