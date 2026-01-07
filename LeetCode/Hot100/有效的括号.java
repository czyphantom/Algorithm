/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 * 题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 难度：Easy
 * 思路：栈
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        char[] sArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : sArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if (c == '}' && top != '{') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == ')' && top != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

