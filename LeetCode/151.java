/**
 * 题目：给定一个字符串，逐个翻转字符串中的每个单词。
 * 难度：Medium
 * 思路：略
 */

public class Solution { 
    public String reverseWords(String s) {
        if (s == null) {
            return null;     
        }
        char[] a = s.toCharArray();
        int n = a.length;   
        //反转整个句子
        reverse(a, 0, n - 1);
        //反转每个单词
        reverseWords(a, n);
        //清除无用空格
        return cleanSpaces(a, n);
    }
    
    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;  
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') {
                i++;
            } 
            while (j < i || j < n && a[j] != ' ') {
                j++; 
            }
            reverse(a, i, j - 1);                     
        }
    }
    
    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') {
                j++;
            }             
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++]; 
            }
            while (j < n && a[j] == ' ') {
                j++; 
            }            
            if (j < n) {
              a[i++] = ' '; 
            }                 
        }
        return new String(a).substring(0, i);
    }
    
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}