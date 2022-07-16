/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 * 题目：给定一个未排序的整数数组nums，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 难度：Medium
 * 思路：
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);
                res = Math.max(res, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                continue;
            }
        }
        return res;
    }
}
// @lc code=end

