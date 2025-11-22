/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 * 题目：给定一个n × n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转90度
 * 难度：Medium
 * 思路：先按主对角线反转一次，再按纵轴反转一次
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < i;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < n/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
// @lc code=end

