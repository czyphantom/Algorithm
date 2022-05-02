/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 * 题目：给你一个整数数组coins ，表示不同面额的硬币；以及一个整数amount，表示总金额。
 * 计算并返回可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * 难度：Medium
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1;i <= amount;i++) {
            for (int j = 0;j < coins.length;j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
// @lc code=end

