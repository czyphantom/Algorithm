/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 * 题目：给定一个三角形triangle，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是下标与上一层结点下标相同或者等于上一层结点下标+ 1的两个结点。也就是说，如果正位于当前行的下标i，那么下一步可以移动到下一行的下标i或i + 1 。
 * 难度：Medium
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) {
            return 0;
        }
        int len = triangle.size();
        int[] dp = new int[len];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }
        for (int i = len - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                dp[j] = row.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
// @lc code=end

