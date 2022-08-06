/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 * 题目：根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意 两个整数之间的除法只保留整数部分。
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 难度：Medium
 * 思路：栈
 */

// @lc code=start
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int target = 0;
                switch(token) {
                    case "+":
                        target = num1 + num2;
                        break;
                    case "-":
                        target = num2 - num1;
                        break;
                    case "*":
                        target = num1 * num2;
                        break;
                    case "/":
                        target = num2/num1;
                        break;                
                }
                stack.push(String.valueOf(target));
            } else {
                stack.push(token);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
// @lc code=end

