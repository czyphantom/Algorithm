/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 * 题目：给你一个m x n的矩阵board，由若干字符'X'和'O' ，找到所有被'X'围绕的区域，并将这些区域里所有的'O'用'X'填充。被围绕的区间不会存在于边界上。
 * 难度：Medium
 * 思路：dfs或者bfs，所有被围绕的O实际上都是直接或者间接与边界的O相连
 */

// @lc code=start
class Solution {
    private int row,col;
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        row = board.length;
        col = board[0].length;
        for(int i = 0;i < row;i++) {
                dfs(board,i,0);
                dfs(board,i,col-1);
        }
        for (int j = 0;j < col;j++) {
                dfs(board,0,j);
                dfs(board,row-1,j);
        }
        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                if (board[i][j]=='O') {
                    board[i][j]='X';
                }
                if (board[i][j]=='-') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    public void dfs(char[][] board,int i,int j) {
        if (i<0 || j<0 || i>=row || j>=col || board[i][j]!='O') {
            return;
        }
        board[i][j]='-';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
        return;
    }
}
// @lc code=end

