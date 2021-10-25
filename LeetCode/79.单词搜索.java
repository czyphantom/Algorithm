/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 * 题目：给定一个m x n二维字符网格board和一个字符串单词word 。如果word存在于网格中，返回true；否则，返回false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 难度：Medium
 * 思路：dfs
 */

// @lc code=start
class Solution {

    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        if(board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int column = board[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
    
        return false;
    }
    
    private boolean search(char[][]board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
    
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
    
        visited[i][j] = true;
        if (search(board, word, i-1, j, index+1) || search(board, word, i+1, j, index+1) ||search(board, word, i, j-1, index+1) || search(board, word, i, j+1, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
}
// @lc code=end

