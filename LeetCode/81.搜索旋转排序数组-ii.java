/*
 * @lc app=leetcode.cn id=81 lang=java
 *
 * [81] 搜索旋转排序数组 II
 * 题目：已知存在一个按非降序排列的整数数组nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums在预先未知的某个下标k（0 <= k < nums.length）上进行了旋转，
 * 使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从0开始计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你旋转后的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果nums中存在这个目标值target，则返回true ，否则返回false 。
 * 难度：Medium
 * 思路：二分，考虑边界情况
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length-1;
        while(begin <= end) {
            int mid = (begin+end)/2;
            if(target == nums[mid]) {
                return true;
            } 
            if(nums[begin] < nums[mid] || nums[mid] > nums[end]) {
                if(target < nums[mid] && target >= nums[begin]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else if(nums[mid] < nums[end] || nums[mid] < nums[begin]) {
                if(target > nums[mid] && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                end--;
            }
        }
        return false;
    }
}
// @lc code=end

