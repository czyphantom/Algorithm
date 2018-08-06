/**
 * 题目：颠倒给定的32位无符号整数的二进制位。
 * 难度：Easy
 * 思路：水题
 */


public class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i = 0;i <= 31;i++){
            res = res + ((1&(n>>i)) << (31-i));
        }
        return res;
    }
}