/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 * 题目：给你一个字符串s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i >= 0) {
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            return i-j;
        }
        return 0;
    }
}
// @lc code=end

