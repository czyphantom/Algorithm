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
        if (nums == null || nums.length <= 2) {
            return nums.length;
        }
        int count = 0,cur = 0, i = 0;
        while (i < nums.length) {
            nums[cur] = nums[i];
            if (i < nums.length - 2 && nums[i+1] == nums[i] && nums[i+2] == nums[i]) {
                nums[cur+1] = nums[i+1];
                int j = i+2;
                while (j < nums.length && nums[j] == nums[i]) {
                    j++;
                }
                i = j;
                cur = cur+2;
            } else {
                i++;
                cur++;
            }
        }
        return cur;
    }
}
// @lc code=end

