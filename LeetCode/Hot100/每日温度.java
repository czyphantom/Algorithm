/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 * 题目：给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第i天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0来代替。
 * 难度：Medium
 * 思路：单调栈
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1;i < temperatures.length;i++) {
            if (temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    int index = stack.pop();
                    result[index] = i-index;
                }
                stack.push(i);
            }
        }
        return result;
    }
}
// @lc code=end

