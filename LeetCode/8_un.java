/**
 * 题目：实现atoi，将字符串转为整数。
 * 难度：Medium
 * 思路：注意边界情况
 */
class Solution {
    public int myAtoi(String str) {
        int digit=0;
        int positive = 1;
        double number=0;
        str = str.trim();
        if(str.length() == 0  || str == null){
            return 0;
        }
        if(str.charAt(0) =='+'){
            positive = 1;
            digit++;
        }
        if(str.charAt(0) == '-'){
            positive = -1;
            digit++;
        }
        while(digit<=str.length()-1){
            int k = 0;
            if(str.charAt(digit)<='9'&&str.charAt(digit)>='0'){
                k = str.charAt(digit) -'0';
                number  = k + number * 10; 
                digit++;
            }
            else{
                break;
            }
        }
        number = number*positive;
        if(number > Integer.MAX_VALUE ){
            return Integer.MAX_VALUE; 
        }
        if(number < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)number;
    }
}