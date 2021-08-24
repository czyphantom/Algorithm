/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 * 题目：给你一个正整数n，生成一个包含1到n^2所有元素，且元素按顺时针顺序螺旋排列的nxn正方形矩阵matrix。
 * 难度：Medium
 * 思路：和54螺旋矩阵类似
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0,j = 0;
        int count = 1;
        int column = n - 1;
        int row = n - 1;
        while(i <= row && j <= column) {
            for(int k = j;k <= column;k++)
                res[i][k] = count++;
            i++;
            for(int k = i;k <= row;k++)
                res[k][column] = count++;
            column--;
    
            if(i <= row) {
                for(int k = column;k >= j;k--)
                    res[row][k] = count++;
            }
            row--;
            if(j <= column) {
                for(int k = row;k >= i;k--)
                    res[k][j] = count++;
            }
            j++;
        }
    
        return res;
    }
}
// @lc code=end

