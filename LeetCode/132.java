/**
 * 题目：给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。返回符合要求的最少分割次数。
 * 难度：Hard
 * 思路：动态规划。
 */

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