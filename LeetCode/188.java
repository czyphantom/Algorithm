/**
 * 题目：给定一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来计算你所能获取的最大利润。你最多可以完成k笔交易。
 * 难度：Hard
 * 思路：123题的一般解，注意k大于prices长度的情况，需要特殊处理。
 */

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length) {
            return solveOtherProblem(prices);
        }
        int len = prices.length;
        //global数组为全局最优解，global[i][j]为到达第i天最多进行j次交易的最大利润
        int[][] global = new int[len][k+1];
        //locate数组为局部最优解，locate[i][j]为第i天最多进行j次交易且在最后一天卖出的最大利润。
        int[][] locate = new int[len][k+1];
        for (int i = 1;i < len;i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1;j <= k;j++) {
                locate[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), locate[i-1][j] + diff);
                global[i][j] = Math.max(locate[i][j], global[i-1][j]);
            }
        }
        return global[len-1][k];
    }

    private int solveOtherProblem(int[] prices) {
        int res = 0;
        for (int i = 1;i < prices.length;i++) {
            if (prices[i] - prices[i-1] > 0) {
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
}