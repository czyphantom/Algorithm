/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 * 题目：给定一个包含n + 1个整数的数组nums ，其数字都在[1, n]范围内（包括1和n），可知至少存在一个重复的整数。
 * 假设nums只有一个重复的整数 ，返回这个重复的数。
 * 难度：Medium
 * 思路：floyd判圈
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
// @lc code=end

