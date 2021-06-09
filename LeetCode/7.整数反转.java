/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }
        return result;

    }
}
// @lc code=end

