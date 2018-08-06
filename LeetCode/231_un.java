/**
 * 题目：给定一个整数，编写一个函数来判断它是否是2的幂次方。
 * 难度：Easy
 * 思路：位运算，利用n&n-1
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n&n-1) == 0) {
            return true;
        }
        return false;
    }
}