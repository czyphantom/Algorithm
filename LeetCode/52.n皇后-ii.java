/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 * 题目：n 皇后问题研究的是如何将n个皇后放置在n×n的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数n，返回n皇后问题不同的解决方案的数量。
 * 难度：Hard
 * 思路：回溯
 */

// @lc code=start
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];   
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        backtracking(0, cols, d1, d2, n);
        return count;
    }
    
    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) {
            count++;
        }
        for(int col = 0; col < n; col++) {
            //主对角线
            int id1 = col - row + n;
            //逆主对角线
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) {
                continue;
            }
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
// @lc code=end

