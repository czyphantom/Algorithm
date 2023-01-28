/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 * 题目：给定一个非负整数数组nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 难度：Medium
 * 思路：贪心
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int cur = 0;
        for (int i = 0;i < nums.length;i++) {
            cur = Math.max(cur, nums[i]+i);
            if (cur <= i && cur < nums.length-1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

