/**
 * 题目：给定一个字符串s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组
 * 合在一起的。重复出现的子串要计算它们出现的次数。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int countBinarySubstrings(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i = 1 ;i < s.length();i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                curRunLength++;
            } else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            if (prevRunLength >= curRunLength) {
                res++;
            }
        }
        return res;
    }
} 