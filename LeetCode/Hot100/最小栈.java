/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 * 题目：设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 难度：Medium
 * 思路：
 */

// @lc code=start
class MinStack {

    Stack<Integer> stack;

    Stack<Integer> minStack;

    public MinStack() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            int top = minStack.peek();
            if (top >= val) {
                minStack.push(val);
            }
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
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

