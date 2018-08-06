/**
* 题目：将一个数组中奇数排在前面，偶数排在后面，保证原本次序不变
* 思路：用空间换时间或者按常规思路来均可
*/

public class Solution{
    public void reOrderArray(int [] array) {
        if(array.length == 0 || array.length == 1)
            return;
        int oddCount=0,oddBegin=0;
        int[] newArray = new int[array.length];

        for(int i = 0;i < array.length;i++){
            if((array[i] & 1) == 1)
                oddCount++;
        }

        for(int i = 0;i < array.length;i++){
            if((array[i] & 1) == 1)
                newArray[oddBegin++] = array[i];
            else newArray[oddCount++] = array[i];
        }
        
        for(int i = 0;i < array.length;i++){
            array[i] = newArray[i];
        }
    }
}
