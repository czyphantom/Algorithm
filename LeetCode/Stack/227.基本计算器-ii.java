/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 * 题目：给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。整数除法仅保留整数部分
 * 难度：Medium
 * 思路：栈
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                default:
                    stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
// @lc code=end

