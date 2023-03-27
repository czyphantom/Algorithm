/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 * 题目：一条包含字母A-Z的消息通过以下映射进行了编码 ：
 * A->1,B->2...Z->26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。
 * 给你一个只含数字的非空字符串s，请计算并返回解码方法的总数 。
 * 难度：Medium
 * 思路：dp
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
// @lc code=end

