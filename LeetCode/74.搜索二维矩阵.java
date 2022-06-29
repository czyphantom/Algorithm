/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 * 题目：编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 难度：Medium
 * 思路：二分
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row * column;
        int low = 0;
        int high = total-1;
        while (low <= high) {
            int mid = (low+high)/2;
            int r = mid/column;
            int c = mid%column;
            if(target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return false;
    }
}
// @lc code=end

