/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 * 题目：设计一个支持push，pop，top操作，并能在常数时间内检索到最小元素的栈。
 * 难度：Medium
 * 思路：两个栈
 */

// @lc code=start
class MinStack {

    private Stack<Integer> min = new Stack<>();

    private Stack<Integer> stack = new Stack<>();


    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (min.isEmpty()) {
            min.push(val);
        } else {
            int top = min.peek();
            if (top >= val) {
                min.push(val);
            }
        }
    }

    public void pop() {
        int val = stack.pop();
        if (min.peek() == val) {
            min.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

