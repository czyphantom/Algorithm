/**
* 题目：循环左移一个字符串
* 思路：水题
*/

public class Solution {
    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len == 0)
            return "";
        StringBuilder builder = new StringBuilder();
        for(int i = n%len;i < len;i++)
            builder.append(str.charAt(i));
        for(int i = 0;i < n%len;i++)
            builder.append(str.charAt(i));
        return builder.toString();
    }
}
