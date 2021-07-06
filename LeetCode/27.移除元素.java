/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 * 题目：给你一个数组nums和一个值val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int position = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != val) {
                nums[position++] = nums[i];
            }
        }
        return position;
    }
}
// @lc code=end

