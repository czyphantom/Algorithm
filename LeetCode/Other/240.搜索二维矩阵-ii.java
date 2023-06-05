/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 * 题目：编写一个高效的算法来搜索m x n矩阵matrix中的一个目标值target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 难度：Medium
 * 思路：z字型查找
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length-1;
        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                i++;
            } else if (matrix[i][j] > target){
                j--; 
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

