/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 * 题目：给你一个m行n列的矩阵matrix，请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 难度：Medium
 * 思路：按照顺序模拟输出即可
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length,column = matrix[0].length;
        int beginRow = 0,beginColumn = 0,endRow = row-1,endColumn = column-1;
        while (beginRow <= endRow && beginColumn <= endColumn) {
            int i = beginRow,j = beginColumn;
            while (j <= endColumn) {
                result.add(matrix[i][j++]);
            }
            beginRow++;
            j--;
            i++;
            if (i > endRow) {
                break;
            }
            while (i <= endRow) {
                result.add(matrix[i++][j]);
            }
            endColumn--;
            i--;
            j--;
            if (j < beginColumn) {
                break;
            }
            while (j >= beginColumn) {
                result.add(matrix[i][j--]);
            }
            endRow--;
            j++;
            i--;
            if (i < beginRow) {
                break;
            }
            while (i >= beginRow) {
                result.add(matrix[i--][j]);
            }
            beginColumn++;
        }
        return result;
    }
}
// @lc code=end

