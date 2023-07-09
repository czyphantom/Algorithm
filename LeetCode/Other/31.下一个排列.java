/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 * 题目：实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * 难度：Medium
 * 思路：找规律
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        //从末尾往前找到第一个非递减位置
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            //从末尾往前找到第一个大于尾数的位置
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length-1);
    }


    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin, end);
            begin++;
            end--;
        }
    }

    private void swap(int[] nums, int begin, int end) {
        int temp = nums[begin];
        nums[begin] = nums[end];
        nums[end] = temp;
    }
}
// @lc code=end

