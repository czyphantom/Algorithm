/*
 * @lc app=leetcode.cn id=188 lang=java
 *
 * [188] 买卖股票的最佳时机 IV
 * 题目：给定一个整数数组prices ，它的第i个元素prices[i]是一支给定的股票在第i天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成k笔交易。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 难度：Hard
 * 思路：动态规划，用两个数组分别记录当前买入的最大收益和卖出的最大收益
 */

// @lc code=start
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);   
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
// @lc code=end

