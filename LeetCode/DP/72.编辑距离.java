/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 * 题目：给你两个单词word1和word2，请你计算出将word1转换成word2所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 难度：Hard
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0;i <= len1;i++) {
            dp[i][0] = i;
        }
        for (int i = 0;i <= len2;i++) {
            dp[0][i] = i;
        }
        for (int i = 1;i <= len1;i++) {
            for (int j = 1;j <= len2;j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

