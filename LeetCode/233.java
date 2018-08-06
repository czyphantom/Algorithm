/**
 * 题目：给定一个整数n，计算所有小于等于n的非负整数中数字1出现的个数。
 * 难度：Hard
 * 思路：略
 */

class Solution {
    public int countDigitOne(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            ones += (n/m+8)/10*m + (n/m%10==1 ? n%m+1 : 0);
        }
        return ones;
    }
}