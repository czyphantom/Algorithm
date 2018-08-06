/**
* 题目大意：对一个二维数组进行查找，二维数组满足每行从左至右递增，每行第一个数大于上一行最后一个数。
* 难度：Medium
* 思路：当做一维数组来做即可。
*/

public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0)
        return false;
    int row = matrix.length;
    int column = matrix[0].length;
    int total = row * column;
    int low = 0;
    int high = total-1;
    while(low <= high) {
        int mid = (low+high)/2;
        int r = mid/column;
        int c = mid%column;
        if(target == matrix[r][c]) {
            return true;
        } else if(target > matrix[r][c]) {
            low = mid+1;
        } else {
            high = mid-1;
        }
    }

    return false;
}
