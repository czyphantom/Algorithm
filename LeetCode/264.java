/**
 * 题目：编写一个程序，找出第n个丑数。丑数就是只包含质因数2, 3, 5的正整数。
 * 难度：Medium
 * 思路：动态规划
 */

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int n2 = 0, n3 = 0, n5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[n2] * 2, dp[n3] * 3), dp[n5] * 5);
            if (dp[i] == dp[n2] * 2) {
                n2++;
            }
            if (dp[i] == dp[n3] * 3) {
                n3++;
            }
            if (dp[i] == dp[n5] * 5) {
                n5++;
            }
        }
        return dp[n - 1];
    }
}