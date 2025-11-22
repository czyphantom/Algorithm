/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 * 题目：编写一个高效的算法来搜索m x n矩阵matrix中的一个目标值target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 难度：Medium
 * 思路：找一个角落的位置，横向和纵向的顺序相反，从这个点开始搜索即可
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int curRow = 0, curColumn = column - 1;
        while (curRow >= 0 && curRow < row && curColumn >= 0 && curColumn < column) {
            if (target > matrix[curRow][curColumn]) {
                curRow++;
            } else if (target < matrix[curRow][curColumn]){
                curColumn--;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

