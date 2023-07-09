/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 * 题目：给定一个m x n二维字符网格board和一个字符串单词word 。如果word存在于网格中，返回true；否则，返回false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0;i < board.length;i++) {
            for (int j = 0;j < board[0].length;j++) {
                if (backTrace(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrace(char[][] board, String word, int cur, int i, int j) {
        if (cur == word.length()) {
            return true;
        }
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length ) {
            if (board[i][j] == word.charAt(cur) && !visited[i][j]) {
                visited[i][j] = true;
                boolean result = backTrace(board, word, cur+1, i+1, j) || dfs(board, word, cur+1, i-1, j) || dfs(board, word, cur+1, i, j+1) || dfs(board, word, cur+1, i, j-1);
                visited[i][j] = false;
                return result;
            }
        }
        return false;
    }
}
// @lc code=end

