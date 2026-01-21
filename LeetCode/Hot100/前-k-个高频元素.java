/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 * 题目：给你一个整数数组nums和一个整数k ，请你返回其中出现频率前k高的元素。你可以按任意顺序返回答案。
 * 难度：Medium
 * 思路：用堆存储top k的元素，或者用快速排序的思想都可
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2.count-o1.count));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        map.forEach((key, value) -> priorityQueue.offer(new Node(key, value)));
        for (int i = 0;i < k;i++) {
            result[i] = priorityQueue.peek().num;
            priorityQueue.remove();
        }
        return result;
    }

    public static class Node {
        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
        public int num;

        public int count;
    }
}
// @lc code=end

