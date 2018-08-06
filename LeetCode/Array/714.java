/**
 * 题目：给定一个整数数组prices，其中第i个元素代表了第i天的股票价格；非负整数fee代表了交易股票的手续费用。你可以无
 * 限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * 返回获得利润的最大值。
 * 难度：Medium
 * 思路：动态规划，计算利润有两种情况，一种是当天卖出，利润加上该次买卖的利润，一种是当天没卖，利润保持原样，另外还
 * 要注意更新当前持有的股票。
 */
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int hold = -prices[0];
        for(int i = 1;i < prices.length;i++) {
            profit = Math.max(profit,prices[i]+hold-fee);
            hold = Math.max(hold,profit-prices[i]);
        }
        return profit;
    }
}