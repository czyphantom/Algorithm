/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 * 题目：整数数组nums按升序排列，数组中的值互不相同。
 * 在传递给函数之前，nums在预先未知的某个下标k
 *（0 <= k < nums.length）上进行了旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 难度：Medium
 * 思路：二分
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int begin = 0, end = nums.length-1;
        while (begin <= end) {
            int mid = (begin+end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[end]) {
                int right = binaraySearch(nums, mid, end, target);
                if (right != -1) {
                    return right;
                }
                end = mid-1;
            } else {
                int left = binaraySearch(nums, begin, mid, target);
                if (left != -1) {
                    return left;
                }
                begin = mid+1;
            }
        }
        return -1;
    }

    private int binaraySearch(int[] nums, int begin, int end, int target) {
        while (begin <= end) {
            int mid = (begin+end)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid-1;
            } else {
                begin = mid+1;
            }
        }
        return -1;
    }
}
// @lc code=end

