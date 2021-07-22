/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 * 题目：给定一个n × n的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转90度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 难度：Medium
 * 思路：先按照主对角线翻转，在按中间轴翻转
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        for (int i = 0;i < matrix.length;i++) {
            for (int j = i;j < matrix[0].length;j++) {
                swap(matrix, i, j);
            }
        }

        for (int i = 0;i < matrix.length;i++) {
            for (int j = 0;j <= (matrix[0].length-1)/2;j++) {
                swapColumn(matrix, i, j);
            }
        }
    }

    private void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    private void swapColumn(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix[0].length-1-j];
        matrix[i][matrix[0].length-1-j] = temp;
    }
}
// @lc code=end

