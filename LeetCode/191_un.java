/**
 * 题目：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为‘1’的个数（也被称为汉明重量）。
 * 难度：Easy
 * 思路：利用n&n-1的关系
 */

public class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n-1);
            res++;
        }
        return res;
    }
}