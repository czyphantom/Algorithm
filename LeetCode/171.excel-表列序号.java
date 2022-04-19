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
        int res = 0;
        for(int i = 0;i < columnTitle.length();i++) {
            res = res * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
// @lc code=end

