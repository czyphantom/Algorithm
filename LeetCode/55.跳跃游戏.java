/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 * 题目：给定一个非负整数数组nums，你最初位于数组的第一个下标。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * 难度：Medium
 * 思路：维护一个count来记录当前能走到的最远距离
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int count = nums[0];
        if(nums.length == 1) {
            return true;
        }
        for(int i = 1;i < nums.length;i++) {
            count--;
            if(count < 0) {
                return false;
            }
            count = Math.max(count,nums[i]);
        }
        return true;
    }
}
// @lc code=end

