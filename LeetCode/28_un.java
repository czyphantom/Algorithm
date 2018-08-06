/**
 * 题目：给定一个haystack字符串和一个needle字符串，在haystack字符串中找出needle字符串出现的第一个位置(从0开始)。
 * 如果不存在，则返回-1。
 * 难度：Easy
 * 思路：字符串匹配
 */

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) 
                    return i;
                if (i + j == haystack.length()) 
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) 
                    break;
            }
        }
    }
}