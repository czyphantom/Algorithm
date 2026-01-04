/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 * 题目：整数数组nums按升序排列，数组中的值互不相同。
 * 在传递给函数之前，nums在预先未知的某个下标k（0 <= k < nums.length）上进行了向左旋转，使数组变为[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后的数组nums和一个整数target，如果nums中存在这个目标值target，则返回它的下标，否则返回-1 。
 * 难度：Meidum
 * 思路：二分变种，边界case考虑下即可
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length-1;
        while (begin <= end) {
            int mid = (end-begin)/2+begin;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                if (nums[mid] > nums[end]) {
                    begin = mid+1;
                } else {
                    if (nums[end] < target) {
                        end = mid-1;
                    } else {
                        begin = mid+1;
                    }
                }
            } else {
                if (nums[mid] > nums[end]) {
                    if (nums[begin] > target) {
                        begin = mid+1;
                    } else {
                        end = mid-1;
                    }
                } else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

