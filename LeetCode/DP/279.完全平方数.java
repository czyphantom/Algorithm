/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 * 题目：给你一个整数n，返回和为n的完全平方数的最少数量。
 * 难度：Medium
 * 思路：四平方和定理或者动态规划
 */

// @lc code=start
class Solution {

    public int numSquares(int n) {
        int[] squares = getSquares();
        int[][] dp = new int[101][n+1];
        for (int i = 0;i <= n;i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        for (int i = 1;i <= 100;i++) {
            for (int j = 1;j <= n;j++) {
                if (j < squares[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-squares[i]]+1);
                }
            }
        }
        return dp[100][n];
    }

    private int[] getSquares() {
        int[] squares = new int[101];
        for (int i = 0;i <= 100;i++) {
            squares[i] = i*i;
        }
        return squares;
    }

    public int numSquares(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, f[i - j * j]);
            }
            f[i] = minn + 1;
        }
        return f[n];
    }
    
    public int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    // 判断是否为完全平方数
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    // 判断是否能表示为 4^k*(8m+7)
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }
}
// @lc code=end

