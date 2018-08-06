/**
 * 题目：给定pushed和popped两个序列，只有当它们可能是在最初空栈上进行的推入push和弹出pop操作序列的结果时，返回true；否则，返回false 。
 * 难度：Medium
 * 思路：模拟入栈出栈的过程，当栈顶元素等于出栈数组的元素时，一直出栈直到不等，否则入栈，最后判断栈是否为空。
 */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        int pushIndex = 0;
        while (pushIndex < pushed.length) {
            stack.push(pushed[pushIndex]);
            pushIndex++;
            while (!stack.isEmpty() && stack.peek() == popped[popIndex] && popIndex < popped.length) {
                popIndex++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}