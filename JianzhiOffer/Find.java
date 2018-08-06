/** 
* 题目：一个二维数组，从左到右递增，从上到下递增，给定一个数，判断是否在该数组中
* 思路：从左下角开始查找比较方便，因为左下角的位置往上递减，往右递增，这样查找时下标往右和往上即可。
*/

public class Solution {
    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0)
            return false;
        int rows = array.length;
        int columns = array[0].length;
        int i = rows-1,j = 0;
        while(i >=0 && i < rows && j >= 0 && j < columns) {
            if(array[i][j] == target)
                return true;
            else if(array[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
