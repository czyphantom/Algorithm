/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 * 题目：给你一个按照非递减顺序排列的整数数组nums，和一个目标值target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 难度：Medium
 * 思路：二分稍微变一下即可
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int begin = 0, end = nums.length-1;
        int res = -1;
        while (begin <= end) {
            int mid = (end-begin)/2+begin;
            if (nums[mid] == target) {
                res = mid;
                end = mid-1;
            } else if (nums[mid] < target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return res;
    }

    private int findLast(int[] nums, int target) {
        int begin = 0, end = nums.length-1;
        int res = -1;
        while (begin <= end) {
            int mid = (end-begin)/2+begin;
            if (nums[mid] == target) {
                res = mid;
                begin = mid+1;
            } else if (nums[mid] < target) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return res;
    }
}
// @lc code=end

