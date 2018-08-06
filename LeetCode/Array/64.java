/**
* 题目大意：找出在一个二维数组中从左上角到右下角的最短路径和
* 难度：Medium
* 思路：dp水题，没什么说的，如果能在原数组上进行修改的话就不需要dp数组，降低复杂度。
*/

public int minPathSum(int[][] grid) {
    int row = grid.length;
    int column = grid[0].length;
    int[][] dp = new int[row][column];
    dp[0][0] = grid[0][0];
    for(int i = 1;i < row;i++) {
        dp[i][0] = dp[i-1][0] + grid[i][0];
    }

    for(int i = 1;i < column;i++) {
        dp[0][i] = grid[0][i] + dp[0][i-1];
    }

    for(int i = 1;i < row;i++) {
        for(int j = 1;j < column;j++) {
            dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
        }
    }

    return dp[row-1][column-1];
}
