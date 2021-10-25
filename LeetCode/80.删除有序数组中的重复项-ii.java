/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 * 题目：给你一个有序数组nums ，请你原地删除重复出现的元素，使每个元素最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组 并在使用O(1)额外空间的条件下完成。
 * 难度：Medium
 * 思路：双指针
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int j = 1;
        if(nums.length < 2) {
            return nums.length;
        }
        for(int i = 1;i < nums.length;i++) {
            if(nums[i] == nums[i-1] && count < 2) {
                count++;
                nums[j++] = nums[i];
            } else if(nums[i] == nums[i-1] && count >= 2) {
                count++;
            } else {
                count = 1;
                nums[j++] = nums[i];
            }
        }
    
        return j;
    }
}
// @lc code=end

