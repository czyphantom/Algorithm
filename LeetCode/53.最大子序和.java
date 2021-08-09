/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 * 题目：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 难度：Easy
 * 思路：
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        int max = nums[0];
        int sum = 0;
        for (int i = 0;i < nums.length;i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        } 
        return max;  
    }
}
// @lc code=end

