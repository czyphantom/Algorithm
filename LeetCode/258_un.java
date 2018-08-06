/**
 * 题目：给定一个非负整数num，反复将各个位上的数字相加，直到结果为一位数。
 * 难度：Easy
 * 思路：结果就是mod9的值
 */

class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        int result = num%9;
        return result == 0 ? 9 : result;
    }
}