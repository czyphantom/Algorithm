/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 * 题目：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 难度：Medium
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0],curSum = nums[0], curMax = nums[0];
        for (int i = 1;i < nums.length;i++) {
            if (curSum > 0) {
                curMax = curSum+nums[i];
                curSum = curMax;
            } else {
                curMax = nums[i];
                curSum = nums[i];
            }
            max = Math.max(curMax, max);
        }
        return max;
    }
}
// @lc code=end

