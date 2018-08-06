/**
 * 题目：不使用运算符+和- ​​​​​​​，计算两整数a 、b​​​​​之和。
 * 难度：Easy
 * 思路：使用异或进行求和，用与计算进位。
 */

class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            //异或求和，不算进位
            int temp = a^b;
            //求进位
            b = (a&b)<<1;
            a = temp;
        }
        return a;
    }
}