/**
 * 题目： 给定一个二维的矩阵，包含'X'和'O'（字母O）。找到所有被'X'围绕的区域，并将这些区域里所有的'O'用'X'填充。
 * 难度：Medium
 * 思路：深度优先搜索，对边界的O直连的O，需要特殊标记一下以便后续操作。
 */

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