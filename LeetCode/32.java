/**
 * 题目：给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * 难度：Hard
 * 思路：用栈或者dp
 */

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int left = -1;
        for(int j = 0;j < s.length();j++){
            if(s.charAt(j)=='(') {
                stack.push(j);  
            }          
            else {
                if (stack.isEmpty()) {
                    left = j;
                }
                else{
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, j-left);
                    }
                    else {
                        max = Math.max(max, j - stack.peek());
                    }
                }
            }
        }
        return max;
    }
}

class Solution2 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (leftCount > 0){
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }
}