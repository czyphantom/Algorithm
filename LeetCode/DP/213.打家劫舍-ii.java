/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 * 题目：你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 难度：Medium
 * 思路：动态规划
 */

// @lc code=start
class Solution {
    //个人解法
    public int rob(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] first = new int[nums.length];
        int[] second = new int[nums.length];
        first[0] = nums[0];
        first[1] = 0;
        second[0]= 0;
        second[1] = nums[1];
        int firstMax = 0;
        int secondMax = 0;
        int max = 0;
        for (int i = 2;i < nums.length;i++) {
            firstMax = Math.max(firstMax, first[i-2]);
            secondMax = Math.max(secondMax, second[i-2]);
            first[i] = Math.max(firstMax+nums[i], first[i-1]);
            second[i] = Math.max(secondMax+nums[i], second[i-1]);
        }
        return Math.max(nums.length == 3 ? nums[0] : first[nums.length-2], second[nums.length-1]);
    }

    //标答
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
// @lc code=end

