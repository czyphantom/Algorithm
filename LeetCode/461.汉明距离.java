/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 * 题目：两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数x和y，计算并返回它们之间的汉明距离。
 * 难度：Easy
 * 思路：
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            s &= s - 1;
            ret++;
        }
        return ret;
    }

    public int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret += s & 1;
            s >>= 1;
        }
        return ret;
    }
}
// @lc code=end

