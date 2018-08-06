/**
 * 题目：输入一个数n，输出一个n*n的矩阵，顺时针方向数字依次为1,2..n^2。
 * 难度：Medium
 * 思路：和54基本如出一辙，改一改即可。
 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0,j = 0;
        int count = 1;
        int column = n - 1;
        int row = n - 1;
        while(i <= row && j <= column) {
            for(int k = j;k <= column;k++)
                res[i][k] = count++;
            i++;
            for(int k = i;k <= row;k++)
                res[k][column] = count++;
            column--;
    
            if(i <= row) {
                for(int k = column;k >= j;k--)
                    res[row][k] = count++;
            }
            row--;
            if(j <= column) {
                for(int k = row;k >= i;k--)
                    res[k][j] = count++;
            }
            j++;
        }
    
        return res;
    }
}