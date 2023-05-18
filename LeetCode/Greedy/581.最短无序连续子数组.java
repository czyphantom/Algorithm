/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 * 题目：给你一个整数数组nums，你需要找出一个连续子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 难度：Medium
 * 思路：将数组分为三段，最左段和最右段都有序，对中间数组排序后整个数组有序，则最左段的数组的最大值<=后面数组的任意值，最右段数组的最小值>=前面数组的任意值
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        //maxn记录0-i-1的最大值，minn记录i+1-n的最小值
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
// @lc code=end

