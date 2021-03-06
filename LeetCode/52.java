/**
 * 题目：求n皇后问题解法的个数
 * 难度：Hard
 * 思路：回溯
 */

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