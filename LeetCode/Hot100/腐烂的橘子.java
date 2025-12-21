/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 * 题目：在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 难度：Medium
 * 思路：BFS
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //存储腐烂的橘子的坐标
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    // 将腐烂橘子的坐标加入队列
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int minutes = 0;
        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty() && freshCount > 0) {
            minutes++;
            int size = queue.size();
            // 处理当前层的所有腐烂橘子
            for (int i = 0; i < size; i++) {
                // 从队列中取出一个腐烂橘子的坐标
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                // 检查四个方向上的相邻单元格
                for (int[] dir : directions) {
                    int nx = x + dir[0], ny = y + dir[1];
                    // 检查新坐标是否在网格范围内且是否是新鲜橘子
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        // 将新鲜橘子变为腐烂状态
                        grid[nx][ny] = 2;
                        // 新鲜橘子数量减一
                        freshCount--;
                        // 将新腐烂的橘子加入队列，用于下一分钟的扩展
                        queue.offer(new int[] { nx, ny });
                    }
                }
            }
        }
        return freshCount == 0 ? minutes : -1;
    }
}
// @lc code=end

