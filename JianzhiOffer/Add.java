/**
* 题目：不用+-*和/计算两数之和
* 思路：利用异或求和，利用按位与求进位
*/

public class Solution {
    public int Add(int num1,int num2) {
        while(num2 != 0) {
            //异或求和，不算进位
            int temp = num1^num2;
            //求进位
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}
