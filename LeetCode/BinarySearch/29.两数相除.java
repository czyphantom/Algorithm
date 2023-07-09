/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 * 题目：给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和mod运算符。
 * 返回被除数dividend除以除数divisor得到的商。
 * 难度：Medium
 * 思路：递归+二分
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {
        boolean isPositive = true;
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)){
            isPositive = false;
        }
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        if (ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
            
        if (ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }
        
        long result = divide(ldividend, ldivisor);
        if (result > Integer.MAX_VALUE) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int)(isPositive ? result : -result);
    }
    
    public long divide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }
        long sum = ldivisor;
        long result = 1;
        
        while (ldividend >= (sum + sum)) {
            sum += sum;
            result += result;
        }
        return result + divide(ldividend - sum, ldivisor);
    }
}
// @lc code=end

