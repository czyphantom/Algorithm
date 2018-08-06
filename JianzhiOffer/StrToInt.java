/**
* 题目：将一个字符串转换为数字
* 思路：注意溢出和符号即可
*/

public class Solution {
    public int StrToInt(String str) {
        int res = 0;
        int symbol = 1;
        boolean isInvalid = false;   
        char[] arr = str.toCharArray();
        
        int n = arr.length;
        if (n <=  0 || str == null) {
            isInvalid = true;
            return 0;
        }
         
        if (arr[0] == '-')
            symbol = -1;
         
        for (int i = (arr[0] ==  '-' || arr[0] == '+') ? 1 : 0; i < n; ++i) {
            if (!('0' <= arr[i] && arr[i] <= '9')) {
                isInvalid = true;
                return 0;
            }
            res=res*10+arr[i]-'0';
             
            if((symbol == 1 && res>Integer.MAX_VALUE) || (symbol == -1 && res < Integer.MIN_VALUE)) {
                isInvalid = true;
                return 0;
            }
        }
         
        return res * symbol;
    }
}