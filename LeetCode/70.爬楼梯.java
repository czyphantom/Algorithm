/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 * 题目：假设你正在爬楼梯。需要n阶你才能到达楼顶。
 * 每次你可以爬1或2个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定n是一个正整数。
 * 难度：Easy
 * 思路：斐波那契数列
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        int x = 1, y = 1;
        if (n <= 1) {
            return 1;
        }
        int result = 1;
        while (n-- > 1) {
            result = x + y;
            y = x;
            x = result;
        }
        return result;
    }
}
// @lc code=end

