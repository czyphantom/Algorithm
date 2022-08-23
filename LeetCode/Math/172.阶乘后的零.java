/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 * 题目：给定一个整数n ，返回n!结果中尾随零的数量。
 * 难度：Medium
 * 思路：因子中有多少5，count=(n/5+n/25+n/125+...)
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        if (n <= 4) {
            return 0;
        }
        int multi = 1;
        int result = 0;
        while (n / (int)(Math.pow(5, multi)) > 0) {
            result +=  n / (int)(Math.pow(5, multi));
            multi++;
        }
        return result;
    }

    //标答
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
// @lc code=end

