/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 * 题目：给你一个整数n，对于0 <= i <= n 中的每个i，计算其二进制表示中1的个数 ，返回一个长度为n + 1的数组ans作为答案。
 * 难度：Easy
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for (int i = 1;i <= n;i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
// @lc code=end

