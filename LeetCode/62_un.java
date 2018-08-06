/**
* 题目：二维数组左上端出发，可以往下或者往右走，问到右下端有多少走法。
* 难度：Medium
* 思路：dp水题，没啥说的，注意就是只有一个元素的时候算一种，即0,0位置的dp数组值为1
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++)
                dp[i][j] = 0;
        }
        for(int i = 1;i < n;i++) {
            dp[0][i] = 1;
        }
    
        for(int i = 1;i < m;i++) {
            dp[i][0] = 1;
        }
    
        for(int i = 1;i < m;i++) {
            for(int j = 1;j < n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    
        return dp[m-1][n-1];
    }
}