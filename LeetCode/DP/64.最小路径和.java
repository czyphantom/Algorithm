/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 * 题目：给定一个包含非负整数的m x n网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 难度：Medium
 * 思路：动态规划水题
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

