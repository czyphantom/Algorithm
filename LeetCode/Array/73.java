/**
* 题目大意：一个二维数组，如果有一个值为0，那么把所在行和列都设为0.
* 难度：Medium
* 思路：如果一个值为0，就把所在行第一个数和所在列第一个数设为0作为标记，第0行0列要特殊考虑，因为第1个
* 是相同的，需要进行区分。
*/

public void setZeroes(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;
    boolean rowflag = false;
    boolean columnflag = false;
    for(int i = 0;i < row;i++) {
        for(int j = 0;j < column;j++) {
            if(matrix[i][j] == 0) {
                if(i == 0)
                    rowflag = true;
                if(j == 0)
                    columnflag = true;
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for(int i = 1;i < row;i++) {
        for(int j = 1;j < column;j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
        }
    }

    if(rowflag) {
        for(int i = 0;i < column;i++)
            matrix[0][i] = 0;
    }

    if(columnflag) {
        for(int i = 0;i < row;i++)
            matrix[i][0] = 0;
    }
}
public void setZeroes(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;
    boolean rowflag = false;
    boolean columnflag = false;
    for(int i = 0;i < row;i++) {
        for(int j = 0;j < column;j++) {
            if(matrix[i][j] == 0) {
                if(i == 0)
                    rowflag = true;
                if(j == 0)
                    columnflag = true;
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    for(int i = 1;i < row;i++) {
        for(int j = 1;j < column;j++) {
            if(matrix[i][0] == 0 || matrix[0][j] == 0)
                matrix[i][j] = 0;
        }
    }

    if(rowflag) {
        for(int i = 0;i < column;i++)
            matrix[0][i] = 0;
    }

    if(columnflag) {
        for(int i = 0;i < row;i++)
            matrix[i][0] = 0;
    }
}
