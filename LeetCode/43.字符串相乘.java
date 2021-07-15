/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 * 题目：给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
 * 难度：Medium
 * 思路：第i位和第j位相乘可以得到结果的第i+j+1位和第i+j位
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1+len2];
        for (int i = len1-1;i >= 0;i--) {
            for (int j = len2-1;j >= 0;j--) { 
                int mul = ((num2.charAt(j)-'0')*(num1.charAt(i)-'0'));
                int sum = mul + result[i+j+1];
                result[i+j+1] = sum%10;
                result[i+j] += sum/10;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int val : result) {
            if (builder.length() != 0 || val != 0) {
                builder.append(val);
            }
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
// @lc code=end

