/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 * 题目：给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 难度：Medium
 * 思路：单调栈
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        Stack<Integer> minStack = new Stack<>();
        for (int i = 0;i < prices.length;i++) {
            if (minStack.isEmpty()) {
                minStack.push(prices[i]);
            } else {
                int min = minStack.peek();
                if (prices[i] > min) {
                    result += prices[i]-min;
                    minStack.clear();
                    minStack.push(prices[i]);
                } else {
                    minStack.push(prices[i]);
                }
            }
        }
        return result;
    }

    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
// @lc code=end

