/**
 * 题目：编写一个函数，其作用是将输入的字符串反转过来。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }
}