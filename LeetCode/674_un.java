/**
 * 题目：给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) {
                anchor = i;
            }
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
}