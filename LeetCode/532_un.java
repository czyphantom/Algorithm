/**
 * 题目：给定一个整数数组和一个整数k, 你需要在数组里找到不同的k-diff数对。这里将k-diff数对定义为一个整数对(i, j),
 * 其中i和j都是数组中的数字，且两数之差的绝对值是k。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                } 
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
}