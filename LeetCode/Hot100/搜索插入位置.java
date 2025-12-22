/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 * 题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 难度：Easy
 * 思路：二分搜索
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int begin = 0,end = nums.length-1;
        while (begin <= end) {
            int mid = (end-begin)/2+begin;
            if (nums[mid] > target) {
                end = mid-1;
            } else if (nums[mid] < target) {
                begin = mid+1;
            } else {
                return mid;
            }
        }
        return begin;
    }
}
// @lc code=end

