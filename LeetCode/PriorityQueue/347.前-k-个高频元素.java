/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 * 题目：给你一个整数数组nums和一个整数k，请你返回其中出现频率前k高的元素。你可以按任意顺序返回答案。
 * 难度：Medium
 * 思路：堆
 */

// @lc code=start
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });        
        countMap.entrySet().forEach(entry -> queue.offer(entry));
        int[] result = new int[k];
        for (int i = 0;i < k;i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
// @lc code=end

