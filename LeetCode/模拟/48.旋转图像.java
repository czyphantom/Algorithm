/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 * 题目：给定一个n×n的二维矩阵matrix表示一个图像。请你将图像顺时针旋转90度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * 难度：Medium
 * 思路：先按照横轴交换，再按主对角线交换
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || matrix[0].length != n) {
            return;
        }
        //先按横轴交换
        for (int i = 0;i < (n+1)/2;i++) {
            for (int j = 0;j < n;j++) {
                swap(matrix, i,j, n-1-i, j);
            }
        }

        //再按主对角线交换
        for (int i = 0;i < n;i++) {
           for (int j = i;j < n;j++) {
               swap(matrix, i, j, j, i);
           }
        }
    }

    private void swap(int[][] matrix, int x, int y, int a, int b) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[a][b];
        matrix[a][b] = temp;
    }
}
// @lc code=end

