/**
 * 题目：根据逆波兰表示法，求表达式的值。有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 难度：Medium
 * 思路：用栈
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (!str.equals("+") && !str.equals("-") && !str.equals("*") && !str.equals("/")) {
                stack.push(Integer.valueOf(str));
            } else {
                Integer value1 = stack.pop();
                Integer value2 = stack.pop();
                if (str.equals("+")) {
                    stack.push(value1 + value2);
                }
                if (str.equals("-")) {
                    stack.push(value2 - value1);
                }
                if (str.equals("*")) {
                    stack.push(value1 * value2);
                }
                if (str.equals("/")) {
                    stack.push(value2 / value1);
                }
            }
        }
        return stack.pop();
    }
}