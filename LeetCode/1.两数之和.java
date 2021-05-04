/*
 * @lc app=leetcode.cn id=1 lang=java
 * [1] 两数之和
 * 题目：给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 难度：Easy
 * 思路：无序数组，二重循环去找。
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i < nums.length;i++) {
            for(int j =i+1;j < nums.length;j++) {
                if(nums[j] == target-nums[i]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result; 
    }
}
// @lc code=end

