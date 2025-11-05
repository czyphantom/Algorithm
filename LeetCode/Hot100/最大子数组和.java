/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 * 题目：给你一个整数数组nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 难度：Medium
 * 思路：利用前缀和做动态规划
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0,max = Integer.MIN_VALUE,preMin = 0;
        for (int i = 0;i < nums.length;i++) {
            pre += nums[i];
            max = Math.max(max, pre-preMin);
            preMin = Math.min(preMin, pre);
        }
        return max;
    }
}
// @lc code=end

