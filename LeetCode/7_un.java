/**
 * 题目：给定一个32位有符号整数，将整数中的数字进行反转。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;

            //溢出的情况
            if ((newResult - tail) / 10 != result){ 
                return 0; 
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
}