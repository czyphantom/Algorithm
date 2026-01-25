/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 * 题目：给定一个数组prices，它的第i个元素prices[i]表示一支给定股票第i天的价格。
 * 你只能选择某一天买入这只股票，并选择在未来的某一个不同的日子卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 * 难度：Easy
 * 思路：就是找当前的价格和之前价格的最小值就是最大利润
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0,min = prices[0];
        for (int i = 1;i < prices.length;i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                result = Math.max(prices[i]-min, result);
            }
        }
        return result;
    }
}
// @lc code=end

