/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 * 题目：给你一个整数数组nums和一个整数k，请你统计并返回该数组中和为k的子数组的个数。
 * 子数组是数组中元素的连续非空序列
 * 难度：Medium
 * 思路：利用前缀和计算子数组的和，同时用哈希表存储来加速查询，前缀和通常用来求子数组的和问题
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        int pre = 0,result = 0;
        //存储前缀和以及出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //默认塞一个0来处理边界情况
        map.put(0, 1);
        for (int i = 1;i < nums.length;i++) {
            pre += nums[i];
            if (map.containsKey(pre-k)) {
                result += map.get(pre-k);
            }
            map.put(pre, map.getOrDefault(pre, 0)+1);
        }
        return result;
    }
}
// @lc code=end

