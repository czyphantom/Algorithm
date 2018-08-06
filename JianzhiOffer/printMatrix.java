/**
* 题目：顺时针打印一个数组
* 思路：一圈一圈打印
*/

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0)
            return res;
        int i = 0,j = 0;
        int row = matrix.length-1;
        int column = matrix[0].length-1;
        while(i <= row && j <= column) {
            for(int k = j;k <= column;k++)
                res.add(matrix[i][k]);
            i++;
            for(int k = i;k <= row;k++)
                res.add(matrix[k][column]);
            column--;

            if(i <= row) {
                for(int k = column;k >= j;k--)
                    res.add(matrix[row][k]);
            }
            row--;
            if(j <= column) {
                for(int k = row;k >= i;k--)
                    res.add(matrix[k][j]);
            }
            j++;
        }
        return res;
    }
}
