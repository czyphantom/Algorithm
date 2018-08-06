/**
 * 题目：数组的每个索引做为一个阶梯，第i个阶梯对应着一个非负数的体力花费值cost[i](索引从0开始)。每当你爬上一个阶
 * 梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。您需要找到达到楼层顶部的最低花费。
 * 在开始时，你可以选择从索引为0或1的元素作为初始阶梯。
 * 难度：Easy
 * 思路：动态规划
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length == 0) {
            return 0;
        }
        if(cost.length == 1) {
            return cost[0];
        }
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i < cost.length;i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return Math.min(dp[cost.length-1]+cost[cost.length-1],dp[cost.length-2]+cost[cost.length-2]);
    }
}