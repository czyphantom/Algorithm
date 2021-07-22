/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 * 题目：实现 pow(x, n) ，即计算x的n次幂函数（即，x^n）。
 * 难度：Medium
 * 思路：二分
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        int t = n/2;
        if(n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        if(n % 2 == 0) {
            return res * res;
        }
        return res * res * x;
    }
}
// @lc code=end

