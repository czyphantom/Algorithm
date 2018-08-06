/**
 * 题目：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        return x == reverse(x);
    }

    private int reverse(int x) {
        int result = 0;
        while(x != 0){
            int remain = x%10;
            x /= 10;
            result = result*10+remain;
        }
        return result;
    }
}