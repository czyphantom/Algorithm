/**
 * 题目：给定一个非空字符串s，最多删除一个字符。判断是否能成为回文字符串。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean validPalindrome(String s) {
        int l = -1, r = s.length();
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindromic(s, l, r+1) || isPalindromic(s, l-1, r);
            }
        }
        return true;
    }
    
    public boolean isPalindromic(String s, int l, int r) {
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}