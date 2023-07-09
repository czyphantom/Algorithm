/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为K的子数组
 * 题目：给你一个整数数组nums和一个整数k，请你统计并返回该数组中和为k的子数组的个数。
 * 难度：Medium
 * 思路：前缀和
 */

// @lc code=start
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
// @lc code=end

