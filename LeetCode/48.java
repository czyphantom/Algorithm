/**
 * 题目：顺时针旋转一个二维数组。
 * 难度：Medium
 * 思路：由于不能使用额外空间，因此需要对数组变换两次。先按主对角线交换，再按中间的垂直对称轴交换。
 */

class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }
}

