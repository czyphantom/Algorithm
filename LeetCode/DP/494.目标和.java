/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 * 题目：给你一个整数数组nums和一个整数target 。
 * 向数组中的每个整数前添加'+'或'-'，然后串联起所有整数，可以构造一个表达式
 * 返回可以通过上述方法构造的、运算结果等于target的不同表达式的数目。
 * 难度：Medium
 * 思路：回溯或者动态规划（背包问题）
 */

// @lc code=start
class Solution {

    private int result = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backTrace(nums, target, 0, 0);
        return result;
    }

    private void backTrace(int[] nums, int target, int curSum, int curIndex) {
        if (curSum == target && curIndex == nums.length) {
            result++;
            return;
        }
        if (curIndex == nums.length) {
            return;
        }
        backTrace(nums, target, curSum+nums[curIndex], curIndex+1);
        backTrace(nums, target, curSum-nums[curIndex], curIndex+1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[n][neg];
    }
}
// @lc code=end

