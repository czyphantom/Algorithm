/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 * 题目：给定一个m x n的矩阵，如果一个元素为0，则将其所在行和列的所有元素都设为0。请使用原地算法。
 * 难度：Medium
 * 思路：如果某个元素为0，就把这个元素的行列的第一项置0，这样就确保能覆盖该行列的所有元素了，对第1行第1列特殊处理
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean colFlag = false, rowFlag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowFlag = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (colFlag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowFlag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
// @lc code=end

