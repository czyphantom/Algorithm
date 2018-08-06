/**
 * 题目：给定字符串S和单词字典words, 求words[i]中是S的子序列的单词个数。
 * 难度：Medium
 * 思路：暴力
 */

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String w : words) {
            int i = 0;  
            int j = 0;   
            while (j < S.length() && i < w.length()) {
                if (S.charAt(j) == w.charAt(i)) {
                    j ++;
                    i ++;
                } else {
                    j ++;
                }
            }
            if (i == w.length()) {
                count++;
            }
        }
        return count;
    }
}

