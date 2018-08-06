/**
 * 题目：给定一个字符串s，找到s中最长的回文子串。你可以假设s的最大长度为1000。
 * 难度：Medium
 * 思路：从中间往两边计算回文串，注意回文串的长度可能是奇数可能是偶数。
 */
class Solution {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len-1; i++) {
            //奇数长度的回文串
            extendPalindrome(s, i, i); 
            //偶数长度的回文串
            extendPalindrome(s, i, i+1);
        }
        return s.substring(lo, lo + maxLen);
    }
    
    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k-j-1) {
            lo = j + 1;
            maxLen = k-j-1;
        }
    }
}