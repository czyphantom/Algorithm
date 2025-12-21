/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 * 题目：你这个学期必须选修numCourses门课程，记为0到numCourses - 1。
 * 在选修某些课程之前需要一些先修课程。先修课程按数组prerequisites给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai则必须先学习课程bi。
 * 难度：Medium
 * 思路：拓扑排序
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> graphMap = new HashMap<>();
        for (int i = 0;i < numCourses;i++) {
            degreeMap.put(i, 0);
            graphMap.put(i, new HashSet<>());
        }
        for (int i = 0;i < prerequisites.length;i++) {
            degreeMap.put(prerequisites[i][0], degreeMap.get(prerequisites[i][0]) + 1);
            graphMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        while (!degreeMap.isEmpty()) {
            boolean hasZero = false;
            List<Integer> removeKey = new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry : degreeMap.entrySet()) {
                if (entry.getValue() == 0) {
                    removeKey.add(entry.getKey());
                    for (Integer node : graphMap.get(entry.getKey())) {
                        degreeMap.put(node, degreeMap.get(node)-1);
                    }
                    graphMap.remove(entry.getKey());
                    hasZero = true;
                }
            }
            if (removeKey.size() != 0) {
                removeKey.forEach(e -> degreeMap.remove(e));
            }
            if (!hasZero) {
                return false;
            } 
        }
        return true;
    }
}
// @lc code=end

