/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 * 题目：给定一个整数数组temperatures ，表示每天的温度，返回一个数组answer，其中answer[i]是指在第i天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用0来代替。
 * 难度：Medium
 * 思路：单调栈
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

