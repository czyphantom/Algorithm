/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 * 题目：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 难度：Easy
 * 思路：略
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int begin = 0, end = s.length()-1;
        while (begin <= end) {
            if (!Character.isLetterOrDigit(s.charAt(begin))) {
                begin++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (!equalsIgnoreCase(s.charAt(begin), s.charAt(end))) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }

    private boolean equalsIgnoreCase(char a, char b) {
        String aStr = Character.toString(a);
        String bStr = Character.toString(b);
        return aStr.equalsIgnoreCase(bStr);
    }
}
// @lc code=end

