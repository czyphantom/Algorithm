/*
 * @lc app=leetcode.cn id=6 lang=java
 * 题目：将一个给定字符串s根据给定的行数numRows，以从上往下、从左到右进行Z字形排列。
 * 难度：Medium
 * 思路：计算规律
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int len = s.length();
        int round = 2*(numRows-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < numRows;i++) {
            for (int j = 0;j+i < len;j += round) {
                sb.append(s.charAt(j+i));
                if (i != 0 && i != numRows-1 && j+round-i < len) {
                    sb.append(s.charAt(j+round-i));
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

