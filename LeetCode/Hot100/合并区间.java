/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 * 题目：以数组intervals表示若干个区间的集合，其中单个区间为intervals[i] = [starti, endi]。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * 难度：Medium
 * 思路：对左节点从小到大排序，依次合并相邻的节点即可
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(intervals[0][0], intervals[0][1]));
        for (int i = 1,j = 0;i < intervals.length;i++) {
            List<Integer> preRes = result.get(j);
            if (intervals[i][0] <= preRes.get(1)) {
                result.get(j).set(1, Math.max(intervals[i][1], preRes.get(1)));
            } else {
                j++;
                result.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
        }
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0;i < resultArray.length;i++) {
            resultArray[i][0] = result.get(i).get(0);
            resultArray[i][1] = result.get(i).get(1);
        }
        return resultArray;
    }
}
// @lc code=end

