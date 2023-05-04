/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 * 题目：给你一个整数n ，求恰由n个节点组成且节点值从1到n互不相同的二叉搜索树有多少种？返回满足题意的二叉搜索树的种数。
 * 难度：Medium
 * 思路：动态规划，G(n)为1-n各节点的二叉搜索树的个数，F(i,n)为以i为根节点，长度为n的二叉搜索树的个数
 */

// @lc code=start
class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }  
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1; 
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i-1-j];
            }
        }
        return dp[n];
    }
}
// @lc code=end

