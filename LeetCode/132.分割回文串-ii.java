/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 * 题目：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 * 难度：Hard
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        boolean[][] p = new boolean[len][len];
        for (int i = 0;i < len;i++) {
            dp[i] = i;
            for (int j = 0;j <= i;j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || p[j+1][i-1])) {
                    p[j][i] = true;
                    dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[len-1];
    }
}
// @lc code=end

