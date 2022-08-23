/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 * 题目：给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0;i < columnTitle.length();i++) {
            int cur = columnTitle.charAt(i) - 'A';
            result = result * 26 + cur + 1;
        }
        return result;
    }
}
// @lc code=end

