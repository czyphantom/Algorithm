/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 * 题目：在一个由'0'和'1'组成的二维矩阵内，找到只包含'1'的最大正方形，并返回其面积。
 * 难度：Medium
 * 思路: 动态规划
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for (int i = 0;i < matrix.length;i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                result = 1;
            }
        }
        for (int i = 0;i < matrix[0].length;i++) {
            if (matrix[0][i] =='1') {
                dp[0][i] = 1;
                result = 1;
            }
        }
        
        for (int i = 1;i < matrix.length;i++) {
            for (int j = 1;j < matrix[0].length;j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    result = Math.max(result, dp[i][j]*dp[i][j]);
                }
            }
        }
        return result;
    }
}
// @lc code=end

