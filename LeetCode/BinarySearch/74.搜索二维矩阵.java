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
        int m = matrix.length,n = matrix[0].length;
        int begin = 0, end = m*n-1;
        while (begin <= end) {
            int mid = (end-begin)/2+begin;
            int i = mid/n;
            int j = mid - ((int)(mid/n)) * n;
            if (matrix[i][j] < target) {
                begin = mid+1;
            } else if (matrix[i][j] == target) {
                return true;
            } else {
                end = mid-1;
            }
        }
        return false;
    }
}
// @lc code=end

