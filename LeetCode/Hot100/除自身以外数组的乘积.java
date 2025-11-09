/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 * 题目：给你一个整数数组nums，返回数组answer ，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 题目数据保证数组nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
 * 难度：Medium
 * 思路：从左到右，从右到左遍历两次数组，一次计算左乘积，一次计算右乘积，两次累乘就是结果
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int left = 1;
        for (int i = 0;i < nums.length;i++) {
            result[i] *= left;
            left *= nums[i];
        }
        int right = 1;
        for (int j = nums.length-1;j >= 0;j--) {
            result[j] *= right;
            right *= nums[j];
        }
        return result;
    }
}
// @lc code=end

