/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 * 题目：一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 难度：Medium
 * 思路：动态规划水题
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (i == 0 || j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        if (i == 0 && j == 0) {
                            dp[i][j] = (obstacleGrid[i][j] == 0 ? 1 : 0);
                        } else if (i == 0) {
                            dp[i][j] = dp[i][j-1];
                        } else {
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                } else {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j-1]+dp[i-1][j];
                    }
                }
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

