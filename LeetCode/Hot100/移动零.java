/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 * 题目：给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 难度：Easy
 * 思路：用一个指针记录新数组不为0的位置，遍历数组，不为0则指针后移，遍历完成后再把该位置及之后的位置全部置0即可
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[cur++] = num;
            } 
        }
        for (int i = cur ;i < nums.length;i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

