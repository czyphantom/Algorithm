/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 * 题目：已知一个长度为n的数组，预先按照升序排列，经由1到n次旋转后，得到输入数组。
 * 给你一个可能存在重复元素值的数组nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的最小元素。
 * 难度：Hard
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
            } else {
                end--;
            }
        }
        return nums[begin];
    }
}
// @lc code=end

