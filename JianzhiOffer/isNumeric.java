/**
* 题目：判断一个字符串是否为数字
* 思路：Java里String转double，遇到异常返回false
*/

public class Solution {
    public boolean isNumeric(char[] str) {
        try {
            double re = Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
