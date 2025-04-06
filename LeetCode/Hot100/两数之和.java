/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 * 题目：给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 可以按任意顺序返回答案。
 * 难度：Easy
 * 思路：用一个哈希表记录每个数字出现的位置，在遍历的时候判断一下哈希表里是否存在target-当前数字的记录即可
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            int otherNum = target - nums[i];
            if (numMap.containsKey(otherNum)) {
                result[0] = i;
                result[1] = numMap.get(otherNum);
                return result;
            } else {
                numMap.put(nums[i], i);
            }
        }
        return result;
    }
}
// @lc code=end

