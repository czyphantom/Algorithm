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
        char[] sArray = s.toCharArray();
        reverse(sArray, 0, sArray.length-1);
        int i = 0,index = 0;
        while (i < sArray.length) {
            if (sArray[i] == ' ') {
                i++;
                continue;
            }
            if (i < sArray.length) {
                int j = i+1;
                while (j < sArray.length && sArray[j] != ' ') {
                    j++;
                }
                reverse(sArray, i, j-1);
                for (int k = i;k < j;k++) {
                    sArray[index++] = sArray[k];
                }
                if (index < sArray.length) {
                    sArray[index++] = ' ';
                }
                i = j;
            }

        }
        if (index < sArray.length || sArray[index-1] == ' ') {
            return new String(sArray, 0, index-1);
        } else {
            return new String(sArray);
        }
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
// @lc code=end

