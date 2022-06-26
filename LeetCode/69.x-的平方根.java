/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 * 题目：给你一个非负整数x，计算并返回x 的平方根 。
 * 由于返回类型是整数，结果只保留整数部分，小数部分将被舍去 。
 * 难度：Easy
 * 思路：牛顿迭代
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) { 
        if (x <= 1) {
            return x;
        }
        double x1 = 0, x2 = 1; 
        while (Math.abs(x1 - x2) > 0.000001) { 
            x1 = x2; 
            x2 = x1/2 + (double)x/(2*x1); 
        } 
        return (int)x1; 
    } 
}
// @lc code=end

