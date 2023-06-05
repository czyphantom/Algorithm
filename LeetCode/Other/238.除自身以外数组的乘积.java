/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 * 题目：给你一个整数数组nums，返回数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据保证数组nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 难度：Medium
 * 思路：
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        int[] result = new int[nums.length];
        for (int i = 0;i < nums.length;i++) {
            if (i == 0) {
                a[i] = 1;
            } else {
                a[i] = a[i-1] * nums[i-1];
            }
        }
        for (int j = nums.length-1;j >= 0;j--) {
            if (j == nums.length-1) {
                b[j] = 1;
            } else {
                b[j] = b[j+1] * nums[j+1];
            }
        }
        for (int i = 0;i < nums.length;i++) {
            result[i] = a[i] * b[i];
        }
        return result;
    }
}
// @lc code=end

