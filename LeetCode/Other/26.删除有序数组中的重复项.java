/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 * 题目：给你一个有序数组nums ，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
         if (nums.length <= 1) {
            return nums.length;
        }
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
// @lc code=end

