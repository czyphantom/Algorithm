/**
 * 题目：设计一个支持push，pop，top操作，并能在常数时间内检索到最小元素的栈。
 * 难度：Easy
 * 思路：水题
 */

class MinStack {
    private Stack<Integer> stack;
    
    public MinStack() {
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(x);
            stack.push(x);
        }else{
            int tmp = stack.peek();
            stack.push(x);
            if(tmp<x){
                stack.push(tmp);
            }else{
                stack.push(x);
            }
        }
    }
    
    public void pop() {
        stack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.get(stack.size()-2);
    }
    
    public int getMin() {
        return stack.peek();
    }
}