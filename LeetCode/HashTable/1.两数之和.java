/*
 * @lc app=leetcode.cn id=1 lang=java
 * [1] 两数之和
 * 题目：给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 难度：Easy
 * 思路：使用map找或者二重循环
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = map.get(target-nums[i]);
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
// @lc code=end

