/**
* 题目：在一个二维数组里是否存在一个字符串的路径
* 思路：回溯
*/

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        boolean[] isReached = new boolean[matrix.length];
        for(int i = 0;i < rows;i++) {
            for(int j = 0;j < cols;j++) {
                if(canReach(matrix,i,j,rows,cols,str,0,isReached))
                    return true;
            }
        }
        return false;
    }
    
    private boolean canReach(char[] matrix,int i,int j,int rows,int cols,char[] str,int k,boolean[] isReached) {
        if(i < 0 || i == rows || j < 0 || j == cols || matrix[i*cols+j] != str[k] || isReached[i*cols+j] == true)
            return false;
        if(k == str.length-1)
            return true;
        isReached[i*cols+j] = true;
        if(canReach(matrix,i+1,j,rows,cols,str,k+1,isReached) || canReach(matrix,i-1,j,rows,cols,str,k+1,isReached)
          || canReach(matrix,i,j+1,rows,cols,str,k+1,isReached) || canReach(matrix,i,j-1,rows,cols,str,k+1,isReached))
            return true;
        isReached[i*cols+j] = false;
        return false;
    }
}
