/**
 * 题目：给定一个Excel表格中的列名称，返回其相应的列序号。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int titleToNumber(String s) {
        int c = 0;
        for (int i = 0;i < s.length();i++) {
            c = (int)((int)s.charAt(i)-64) * (int)Math.pow(26,s.length()-i-1) + c;
        }
        return c;
    }
}