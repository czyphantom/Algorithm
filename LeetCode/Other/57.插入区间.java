/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 * 题目：给你一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 难度：Medium
 * 思路：模拟
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> result = new LinkedList<>();
        boolean put = false;
        for (int i = 0;i < intervals.length;i++) {
            if (!put && newInterval[0] > intervals[i][1]) {
                result.add(intervals[i]);
            } else if (!put && newInterval[0] <= intervals[i][1]) {
                if (newInterval[1] < intervals[i][0]) {
                    result.add(newInterval);
                    result.add(intervals[i]);
                } else {
                    intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
                    intervals[i][0] = Math.min(intervals[i][0], newInterval[0]);
                    result.add(intervals[i]);
                }   
                put = true;               
            } else {
                if (intervals[i][0] > result.getLast()[1]) {
                    result.add(intervals[i]);
                } else {
                    result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
                }
            }
        }
        if (!put) {
            result.add(newInterval);
        }
        return result.toArray(new int[result.size()][]);
    }
}
// @lc code=end

