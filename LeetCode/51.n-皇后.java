/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 * 题目:n 皇后问题 研究的是如何将n个皇后放置在n×n的棋盘上，并且使皇后彼此之间不能相互攻击。给你一个整数n，返回所有不同的n皇后问题的解决方案。
 * 每一种解法包含一个不同的n皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 难度：Hard
 * 思路 校验每次放置位置是否能组成n皇后
 */

// @lc code=start
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }
    
    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return;
        }
        
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
// @lc code=end

