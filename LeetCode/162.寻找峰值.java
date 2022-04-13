/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 * 题目：峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设nums[-1] = nums[n] = -∞ 。
 * 难度：Medium
 * 思路：对于任意位置，如果nums[i] < nms[i+1]，峰值可能在右边，同理可得另外的情况，二分即可得到答案


 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int mid = begin + (end-begin)/2;
            if (nums[mid] < nums[mid+1]) {
                begin = mid + 1;
            } else {
                end = mid;
            }
        }
        return begin;
    }
}
// @lc code=end

