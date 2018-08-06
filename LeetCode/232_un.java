/**
 * 题目：使用栈实现队列
 * 难度：Easy
 * 思路：水题，除了使用双栈外，还可以记录头尾位置来实现。
 */

class MyQueue {

    private Stack<Integer> stack;
    private int size;
    private int front;
    private int tail;
    
    public MyQueue() {
        stack = new Stack<>();
        size = 0;
        front = 0;
        tail = 0;
    }
    
    public void push(int x) {
        stack.push(x);
        tail++;
        size++;
    }
    
    public int pop() {
        int temp = stack.get(front);
        front++;
        size--;
        if(front == tail){
            Stack newstack = new Stack<>();
            stack = newstack;
            front = 0;
            tail = 0;
            size = 0;
        }
        return temp;
    }
    
    
    public int peek() {
        return stack.get(front);
    }
    
    public boolean empty() {
        return size == 0;
    }
}