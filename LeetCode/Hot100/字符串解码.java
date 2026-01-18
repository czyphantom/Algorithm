/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 * 题目：给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的encoded_string正好重复k次。注意k保证为正整数。
 * 难度：Medium
 * 思路：栈，和标答略有差异
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        char[] sArray = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder strBuilder = new StringBuilder();
        int i = 0;
        while (i < sArray.length) {
            if (sArray[i] >= '0' && sArray[i] <= '9') {
                int j = i+1;
                while (j < sArray.length && (sArray[j] >= '0' && sArray[j] <= '9')) {
                    j++;
                }
                int count = Integer.parseInt(s.substring(i, j));
                numStack.add(count);
                i = j;
            } else if (sArray[i] == '[') {
                int j = i+1;
                while (j < sArray.length && (sArray[j] < '0' || sArray[j] > '9') && sArray[j] != ']') {
                    j++;
                }
                strStack.push(s.substring(i+1,j));
                i = j;
            } else if (sArray[i] == ']') {
                StringBuilder builder = new StringBuilder();
                String str = strStack.pop();
                int count = numStack.pop();
                for (int j = 1;j <= count;j++) {
                    builder.append(str);
                }
                if (!strStack.isEmpty()) {
                    String top = strStack.pop();
                    String newStr = top + builder.toString();
                    strStack.push(newStr);
                } else {
                    strBuilder.append(builder);
                }
                i++;
            } else {
                int j = i+1;
                while (j < sArray.length && (sArray[j] < '0' || sArray[j] > '9') && sArray[j] != ']' && sArray[j] != '[') {
                    j++;
                }
                if (strStack.isEmpty()) {
                    strBuilder.append(s.substring(i,j));
                } else {
                    String top = strStack.pop();
                    String newStr = top + s.substring(i,j);
                    strStack.push(newStr);
                }
                i = j;
            }
        }
        return strBuilder.toString();
    }
}
// @lc code=end

