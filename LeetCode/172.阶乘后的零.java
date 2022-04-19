/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 * 题目：给定一个整数n ，返回n!结果中尾随零的数量。
 * 难度：Medium
 * 思路：因子中有多少5，可以用对数记算法求解
 */

// @lc code=start
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5;i <= n;i += 5) {
            count += countFive(i);
        }
        return count;
    }

    private int countFive(int n) {
        int count = 0;
        while (n % 5 == 0 && n > 0) {
            n /= 5;
            count++;
        }
        return count;
    }

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
// @lc code=end

