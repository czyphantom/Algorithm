/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 * 题目：给定三个字符串s1、s2、s3，请你帮忙验证s3是否是由s1和s2交错组成的。
 * 两个字符串s和t交错的定义与过程如下，其中每个字符串都会被分割成若干非空子字符串：
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 难度：Medium
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        //如果其中一个串为空串，只要判断其中一个串和s3是否相等
        dp[0][0] = true;
        for (int i = 1;i <= len1;i++) {
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for (int i = 1;i <= len2;i++) {
            dp[0][i] = dp[0][i-1] && (s2.charAt(i-1) == s3.charAt(i-1));
        }
        for (int i = 1;i <= len1;i++) {
            for (int j = 1;j <= len2;j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i-1+j)) || (dp[i][j-1] & s2.charAt(j-1) == s3.charAt(j-1+i));
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

