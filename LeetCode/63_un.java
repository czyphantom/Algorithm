/**
* 题目：和62比就是多了数组中有的元素为1表示障碍
* 难度：Medium
* 思路：和62差不多
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row  = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int dp[][] = new int[row][column];
        for(int i = 0;i < row;i++) {
            for(int j = 0;j < column;j++)
                dp[i][j] = 0;
        }
    
        for(int i = 0;i < row;i++) {
            if(obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            else
                break;
        }
    
        for(int i = 0;i < column;i++) {
            if(obstacleGrid[i][0] != 1)
                dp[0][i] = 1;
            else
                break;
        }
    
        for(int i = 1;i < row;i++) {
            for(int j = 1;j < column;j++) {
                if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    
        return dp[row-1][column-1];
    }
}