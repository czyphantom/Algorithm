/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 * 题目：给定一个m x n的矩阵，如果一个元素为0 ，则将其所在行和列的所有元素都设为0 。请使用原地算法。
 * 难度：Medium
 * 思路：如果某个位置为0，在该行该列第一个位置置0来代表需要将该行该列清零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        boolean rowflag = false;
        boolean columnflag = false;
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < column;j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) {
                        rowflag = true;
                    }
                    if(j == 0) {
                        columnflag = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    
        for(int i = 1;i < row;i++) {
            for(int j = 1;j < column;j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    
        if(rowflag) {
            for(int i = 0;i < column;i++) {
                matrix[0][i] = 0;
            }
        }
    
        if(columnflag) {
            for(int i = 0;i < row;i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
// @lc code=end

