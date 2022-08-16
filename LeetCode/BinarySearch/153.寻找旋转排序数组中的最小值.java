/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 * 题目：已知一个长度为n的数组，预先按照升序排列，经由1到n次旋转后，得到输入数组。
 * 给你一个元素值互不相同的数组nums，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的最小元素。
 * 你必须设计一个时间复杂度为O(log n)的算法解决此问题。
 * 难度：Medium
 * 思路：二分
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int begin = 0,end = nums.length-1;
        while (begin < end) {
            int mid = (end-begin)/2+begin;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                begin = mid+1;
            }
        }
        return nums[begin];
    }
}
// @lc code=end

