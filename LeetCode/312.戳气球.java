/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 * 题目：有n个气球，编号为0到n - 1，每个气球上都标有一个数字，这些数字存在数组nums中。
 * 现在要求你戳破所有的气球。戳破第i个气球，你可以获得nums[i - 1] * nums[i] * nums[i + 1]枚硬币。 
 * 这里的i - 1和i + 1代表和i相邻的两个气球的序号。如果i - 1或i + 1超出了数组的边界，那么就当它是一个数字为1的气球。
 * 求所能获得硬币的最大数量。
 * 难度：Hard
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }
}
// @lc code=end

