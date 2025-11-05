/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 * 题目：给定一个整数数组nums，将数组中的元素向右轮转k个位置，其中k是非负数。
 * 难度：Medium
 * 思路：倒转数组多次即可得到
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        reverse(nums, 0, len);
        reverse(nums,0, k);
        reverse(nums,k, len);
    }

    private void reverse(int[] nums, int begin, int end) {
        int i = begin,j = end-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
// @lc code=end

