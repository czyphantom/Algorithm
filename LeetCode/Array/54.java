/** 题目大意：按顺时针方向将一个二维数组一圈一圈加入到一个一维数组中。
* 难度：Medium
* 思路：从左到右，从上到小...每一圈按照这样的方式来加入大结果中。
*/

public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
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
