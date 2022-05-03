/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 * 题目：给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * 难度：Easy
 * 思路：双指针
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0;i < nums.length;i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for(int i = index;i < nums.length;i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

