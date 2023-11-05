/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 * 题目：给定一个含有n个正整数的数组和一个正整数target 。
 * 找出该数组中满足其总和大于等于target的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回0。
 * 难度：Medium
 * 思路：双指针
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int slow = 0,fast = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (fast < nums.length) {
            sum += nums[fast];
            if (sum >= target) {
                while (slow <= fast && sum >= target) {
                    sum -= nums[slow];
                    slow++;
                }
                min = Math.min(min, fast-slow+2);
                fast++;
            } else {
                fast++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// @lc code=end

