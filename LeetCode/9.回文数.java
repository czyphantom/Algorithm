/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 * 难度：Easy
 * 思路：反转即可
 */

// @lc code=start
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
// @lc code=end

