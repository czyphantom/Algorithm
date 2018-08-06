/**
 * 题目：在一个由0和1组成的二维矩阵内，找到只包含1的最大正方形，并返回其面积。
 * 难度：Medium
 * 思路：动态规划。
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for (int i = 1;i <= matrix.length;i++) {
            for (int j = 1;j <= matrix[0].length;j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}