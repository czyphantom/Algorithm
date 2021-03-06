/**
 * 题目：实现一个基本的计算器来计算一个简单的字符串表达式的值。字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和
 * 空格。整数除法仅保留整数部分。
 * 难度：Medium
 * 思路：扫描两遍，第一遍计算乘除，第二遍计算加减，坑点在于因为除法保留整数，因此从右往左算和从左往右算结果不同。
 */


public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c-'0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    cur = cur * 10 + s.charAt(i+1) - '0';
                    ++i;
                }
                if (!list.isEmpty() && (list.peek() == 2 || list.peek() == 3)) {
                    int op = list.pop();
                    int opl = list.pop();
                    int res = 0;
                    if(op==2) res = opl * cur;
                    else res = opl / cur;
                    list.push(res);
                } else {
                    list.push(cur);
                }               
            } else if(c == ' ') {
                continue;
            } else {
                switch (c) {
                    case '+': 
                        list.push(0);
                        break;
                    case '-': 
                        list.push(1);
                        break;
                    case '*': 
                        list.push(2);
                        break;
                    case '/': 
                        list.push(3);
                        break;
                    default: 
                        return -1;
                }
            }
        }
        
        if(list.isEmpty()) return 0;
        Collections.reverse(list);
        
        int res = list.poll();
        
        while(!list.isEmpty()) {
        	int op = list.poll();
        	int opr = list.poll();
        	if(op==0) res += opr;
        	else res -= opr;
        }
        return res;
    }
}