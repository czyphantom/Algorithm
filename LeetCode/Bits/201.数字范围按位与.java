/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 * 题目：给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 * 难度：Medium
 * 思路：利用n&n-1可以消除n最右边的1，本质上是求bit的最长公共前缀
 */

// @lc code=start
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right-1);
        }
        return right;
    }
}
// @lc code=end

