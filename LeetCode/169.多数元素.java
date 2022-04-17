/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 * 题目：给定一个大小为n的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊n/2⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 难度：Easy
 * 思路：摩尔投票
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1;i < nums.length;i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                result = nums[i];
                count = 1;
            }
        }
        return result;
    }
}
// @lc code=end

