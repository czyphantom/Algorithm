/**
 * 题目：给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * *可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 难度：Medium
 * 思路：记录把*当作(和当作)的个数。或者用两个栈记录(和*的下标
 */

class Solution {
    public boolean checkValidString(String s) {
        //记录把*当作(
        int most = 0;
        //记录把*当作)
        int least = 0;  
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                least++;
                most++;
            } else if (c == ')') {
                if (least > 0) {
                    least--;
                }
                most--;
            } else {
                if (least > 0) {
                    least--;
                }
                most++;
            }
            if (most < 0) {
                return false;
            }
        }
        return least == 0;
    }
}