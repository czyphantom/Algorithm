/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 难度：Easy
 * 思路：横向扫描，以第一个为基准依次比较每一个字符串的公共前缀，或者纵向扫描一个字符串一个字符串的比
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1;i < strs.length;i++) {
            int j = 0;
            for (;j < Math.min(strs[i].length(), prefix.length());j++) {
                if (strs[i].charAt(j) != prefix.charAt(j)) {
                    break;
                }
            }
            prefix = strs[i].substring(0, Math.min(j, prefix.length()));
        }
        return prefix;
    }
}
// @lc code=end

