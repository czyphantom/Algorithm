/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 * 题目：你这个学期必须选修numCourses门课程，记为0到numCourses - 1。在选修某些课程之前需要一些先修课程。先修课程按数组prerequisites给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai则必须先学习课程bi。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * 难度：Medium
 * 思路：拓扑排序
 */

// @lc code=start
class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        visited = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        return valid;
    }

    public void dfs(int u) {
        visited[u] = 1;
        for (int v: edges.get(u)) {
            if (visited[v] == 0) {
                dfs(v);
                if (!valid) {
                    return;
                }
            } else if (visited[v] == 1) {
                valid = false;
                return;
            }
        }
        visited[u] = 2;
    }
}
// @lc code=end

