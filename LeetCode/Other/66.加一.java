/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 * 题目：给定一个由 整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数0之外，这个整数不会以零开头。
 * 难度：Easy
 * 思路：水题
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int[] arr;

        int one = 1;

        for(int i = length-1;i >= 0;i--) {
            int val = digits[i] + one;
            one = val/10;
            digits[i] = val % 10;
        }
        if(one == 0) {
            return digits;
        } else {
            arr = new int[length + 1];
            arr[0] = 1;
            for(int j = 1;j < length + 1;j++) {
                arr[j] = digits[j-1];
            }
            return arr;
        }
    }
}
// @lc code=end

