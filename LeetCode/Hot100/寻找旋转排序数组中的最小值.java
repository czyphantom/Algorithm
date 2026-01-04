/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 * 题目：找出旋转数组中的最小值
 * 难度：Medium
 * 思路：二分
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int begin = 0, end = nums.length-1;
        while (begin < end) {
            int mid = (end-begin)/2+begin;
            if (nums[mid] > nums[end]) {
                begin = mid+1;
            } else {
                end = mid;
            }
        }
        return nums[begin];
    }
}
// @lc code=end

