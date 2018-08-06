/**
 * 题目：给定正整数n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于n。你需要让组成和的完全平方数的个数最少。
 * 难度：Medium
 * 思路：动态规划，递推关系为：dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j])
 */

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; i++) 
            dp[i * i] = 1;
        for(int i = 1; i <= n; i++) { 
            for(int j = 1; i + j * j <= n; j++) { 
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);
            }
        }
        return dp[n];
    }
}