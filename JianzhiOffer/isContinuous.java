/**
* 题目：找出数组中是否有顺子，0可以作任何数字
* 思路：顺子的条件为5个数中最大值与最小值差小于5且没有对子
*/

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length != 5)
            return false;
        int min = 14,max = -1;
        int[] temp = new int[13];
        for(int i = 0;i < numbers.length;i++) {
            if(numbers[i] < 0 || numbers[i] > 13)
                return false;
            if(numbers[i] < min && numbers[i] != 0)
                min = numbers[i];
            if(numbers[i] > max && numbers[i] != 0)
                max = numbers[i];
            if(numbers[i] != 0)
                temp[numbers[i]]++;
        }
        for(int i = 0;i < 13;i++) {
            if(temp[i] >= 2)
                return false;
        }
        if(max-min >= 5)
            return false;
        return true;
    }
}
