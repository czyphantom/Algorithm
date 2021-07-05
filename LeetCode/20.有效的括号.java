/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 * 题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串s，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 难度：Easy
 * 思路：用栈即可
 */

// @lc code=start
class Solution {
    private  Map<Character,Character> map = new HashMap<>();
     {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty() && map.get(stack.peek()) == s.charAt(i)) {
                    stack.poll();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

