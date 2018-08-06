/**
 * 题目：给定一个整数n，返回n!结果尾数中零的数量。
 * 难度：Easy
 * 思路：水题，计算5的因子数即可。
 */

class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            count += n/5;
            n /= 5;
        }
        return count;
    }
}