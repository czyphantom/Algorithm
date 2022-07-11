/*
 * @lc app=leetcode.cn id=115 lang=java
 *
 * [115] 不同的子序列
 * 题目：给定一个字符串s和一个字符串t ，计算在s的子序列中t出现的个数。
 * 字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 难度：Hard
 * 思路：dp
 */

// @lc code=start
class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for(int j = 0; j <= s.length(); j++){
            dp[0][j] = 1;
        }

        for(int i = 1; i <= t.length(); i++) {
            for(int j = 1; j <= s.length(); j++) {
                if(t.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}
// @lc code=end

