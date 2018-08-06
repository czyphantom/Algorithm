/**
* 题目：反转一个句子
* 思路: 水题
*/

import java.util.*;
public class Solution {
    public String ReverseSentence(String str) {
        StringBuilder builder = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = str.length()-1;i >= 0;i--) {
            if(str.charAt(i) != ' ')
                st.push(str.charAt(i));
            else {
                while(!st.isEmpty()) {
                    builder.append(st.pop());
                }
                builder.append(' ');
            }
        }
        while(!st.isEmpty()) {
            builder.append(st.pop());
        }
        return builder.toString();
    }
}
