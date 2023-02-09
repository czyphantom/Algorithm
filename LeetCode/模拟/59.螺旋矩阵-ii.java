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
        int[][] result = new int[n][n];
        if (n <= 0) {
            return result;
        }
        int row = n,column = n;
        int beginRow = 0,beginColumn = 0,endRow = row-1,endColumn = column-1;
        int num = 1;
        while (beginRow <= endRow && beginColumn <= endColumn) {
            int i = beginRow,j = beginColumn;
            while (j <= endColumn) {
                result[i][j++] = num++;
            }
            beginRow++;
            j--;
            i++;
            if (i > endRow) {
                break;
            }
            while (i <= endRow) {
                result[i++][j] = num++;
            }
            endColumn--;
            i--;
            j--;
            if (j < beginColumn) {
                break;
            }
            while (j >= beginColumn) {
                result[i][j--] = num++;
            }
            endRow--;
            j++;
            i--;
            if (i < beginRow) {
                break;
            }
            while (i >= beginRow) {
                result[i--][j] = num++;
            }
            beginColumn++;
        }
        return result;

    }
}
// @lc code=end

