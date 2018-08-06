/**
 * 题目：如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。给定一个MxN的矩阵，当
 * 且仅当它是托普利茨矩阵时返回True。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        for(int i = 0;i < y;i++) {
            for(int j = i,k = x-1;j >= 0 && k >= 0;k--,j--) {
                int temp = matrix[x-1][i];
                if(matrix[k][j] != temp) {
                    return false;
                }
            }
        }
        for(int i = 0;i < x;i++) {
            for(int j = i,k = y-1;k >= 0 && j >= 0;k--,j--) {
                int temp = matrix[i][y-1];
                if(matrix[j][k] != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}