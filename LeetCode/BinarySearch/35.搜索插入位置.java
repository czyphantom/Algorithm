/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 * 题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 难度；Easy
 * 思路：二分
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int begin = 0, end = n - 1, res = n;
        while (begin <= end) {
            int mid = (end - begin) /2 + begin;
            if (target <= nums[mid]) {
                res = mid;
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return res;
    }
}
// @lc code=end
/
