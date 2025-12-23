/*
 * @lc app=leetcode.cn id=74 lang=java
 *
 * [74] 搜索二维矩阵
 * 题目：给你一个满足下述两条属性的m x n整数矩阵：
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 难度：Medium
 * 思路：二分搜索的变种
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length;
        int begin = 0,end = m*n-1;
        while (begin <= end) {
            int mid = (end-begin)/2+begin;
            int x = mid/n,y = mid%n;
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                end = mid-1;
            } else {
                begin = mid+1;
            }
        }
        return false;
    }
}
// @lc code=end

