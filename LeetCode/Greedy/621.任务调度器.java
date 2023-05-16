/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 * 题目：给你一个用字符数组tasks表示的CPU需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在1个单位时间内执行完。在任何一个单位时间，CPU可以完成一个任务，或者处于待命状态。
 * 然而，两个相同种类的任务之间必须有长度为整数n的冷却时间，因此至少有连续n个单位时间内CPU在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 * 难度：Medium
 * 思路：贪心
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        // 最多的执行次数
        int maxExec = 0;
        for (char ch : tasks) {
            int exec = freq.getOrDefault(ch, 0) + 1;
            freq.put(ch, exec);
            maxExec = Math.max(maxExec, exec);
        }

        // 具有最多执行次数的任务数量
        int maxCount = 0;
        Set<Map.Entry<Character, Integer>> entrySet = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            int value = entry.getValue();
            if (value == maxExec) {
                ++maxCount;
            }
        }

        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
}
// @lc code=end

