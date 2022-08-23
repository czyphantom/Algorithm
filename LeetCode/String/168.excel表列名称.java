/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 * 题目：给你一个整数columnNumber，返回它在Excel表中相对应的列名称。
 * 难度：Easy
 * 思路：类似进制转换
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int remain = columnNumber%26;
            char c = (char)('A' + remain);
            builder.append(c);
            columnNumber /= 26;
        }
        return builder.reverse().toString();
    }
}
// @lc code=end

