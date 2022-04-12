/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 * 题目：给你一个字符串s，颠倒字符串中单词的顺序。
 * 单词是由非空格字符组成的字符串。s中使用至少一个空格将字符串中的单词分隔开。
 * 返回单词顺序颠倒且单词之间用单个空格连接的结果字符串。
 * 难度：Medium
 * 思路：先全翻转一次，再将每个单词翻转一次。
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] str = s.toCharArray();
        reverse(str, 0, s.length());
        int i = 0,j = 0;
        while (str[j] == ' ' && j < s.length()) {
            j++;
        }
        boolean flag = false;
        while (j < s.length()) {
            int k = j+1;
            while(k < s.length() && str[k] != ' ') {
                k++;
            }
            reverse(str, j, k);
            for (int r = j;r < k;r++) {
                str[i++] = str[r];
            }
            if (i < s.length()) {
                str[i++] = ' ';
            }  else {
                flag = true;
            }
            while (k < s.length() && str[k] == ' ') {
                k++;
            }
            j = k;
        }
        if (flag) {
            return new String(str, 0, i);
        } else {
            return new String(str, 0, i-1);
        }
        
    }

    public void reverse(char[] str, int begin, int end) {
        int i = begin,j = end-1;
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}
// @lc code=end

