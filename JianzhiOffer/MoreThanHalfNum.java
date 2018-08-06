/**
* 题目：找出一个数组中出现次数超过一半的数
* 思路：在遍历数组时，保存出现次数大于等于1的数，如果次数为0时，设置新的保存的数，这样遍历结束时保存的数
* 即为要找的数，再遍历一次对该数进行确认。
*/

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0)
            return 0;
        int len = array.length;
        int count = 0;
        int num = array[0];
        for(int i = 0;i < len;i++) {
            if(array[i] == num)
                count++;
            else
                count--;
            if(count == 0) {
                num = array[i];
                count = 1;
            }
        }
        count = 0;
        for(int i = 0;i < len;i++) {
            if(array[i] == num)
                count++;
        }
        if(count * 2 > len)
            return num;
        return 0;
    }
}
