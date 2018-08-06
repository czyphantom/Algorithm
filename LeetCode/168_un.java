/**
 * 题目：给定一个正整数，返回它在Excel表中相对应的列名称。
 * 难度：Easy
 * 思路：水题，26进制。
 */

class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }
}