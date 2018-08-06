/**
* 题目：一个机器人从二维矩阵的左上角开始走，可以向四个方向走，但是数位和不能大于给定值，问能走到多少个格
* 子
* 思路：回溯
*/

public class Solution {
    public int movingCount(int threshold, int rows, int cols) {
        boolean isReached[][] = new boolean[rows][cols];
        return move(threshold,0,0,rows,cols,isReached);
    }
    
    private int move(int threshold,int currow,int curcol,int rows,int cols,boolean[][] isReached) {
        if(currow < 0 || currow == rows || curcol < 0 || curcol == cols || getNumberSum(currow)+getNumberSum(curcol) > threshold || isReached[currow][curcol] == true) {
            return 0;
        }
        isReached[currow][curcol] = true;
        return 1+move(threshold,currow+1,curcol,rows,cols,isReached)+move(threshold,currow-1,curcol,rows,cols,isReached)
            +move(threshold,currow,curcol+1,rows,cols,isReached)+move(threshold,currow,curcol-1,rows,cols,isReached);
    }
    
    private int getNumberSum(int num) {
        int sum = 0;
        while(num != 0) {
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
