/**
* 题目：一个数组中数字大小为0-n-1，找出任意一个重复的数字
* 思路：在一轮扫描的时候就对该索引上的数字为索引的数字进行处理+n。
*/

public class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length != length)
            return false;
        for(int i = 0;i < length;i++) {
            int index = numbers[i];
            if(index >= length)
                index -= length;

            if(numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }
}
