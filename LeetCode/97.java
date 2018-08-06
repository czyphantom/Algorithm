/**
 * 题目：给定三个字符串s1, s2, s3, 验证s3是否是由s1和s2交错组成的。
 * 难度：Hard
 * 思路：动态规划
 */

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