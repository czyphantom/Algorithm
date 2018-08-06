/**
* 题目：给一个入栈的数组，一个出栈的数组，判断是否成立
* 思路：模拟入栈出栈的过程，当栈顶元素等于出栈数组的元素时，一直出栈直到不等，否则入栈，最后判断栈是否为
* 空
*/

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0)
            return false;
        Stack<Integer> s = new Stack<>();
        int i = 0,j = 0;
        while(i < pushA.length) {
            s.push(pushA[i++]);
            while(j < popA.length && s.peek() == popA[j]) {
                s.pop();
                j++;
            }
        }
        return s.empty();
    }
}
