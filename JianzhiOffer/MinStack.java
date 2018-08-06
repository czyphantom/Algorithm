/**
* 题目：实现一个可以得到最小值的栈
* 思路：用另一个栈保存最小值
*/

public class Solution {

    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();
    
    public void push(int node) {
        st1.push(node);
        if(st2.empty() || node < st2.peek())
            st2.push(node);
    }
    
    public void pop() {
        if(st1.peek() == st2.peek())
            st2.pop();
        st1.pop();
        
    }
    
    public int top() {
        return st1.peek();
    }
    
    public int min() {
        return st2.peek();
    }
}
