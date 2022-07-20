/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 * 题目：给你一个整数数组nums，除某个元素仅出现一次外，其余每个元素都恰出现三次。请你找出并返回那个只出现了一次的元素。
 * 难度：Medium
 * 思路：可以看做设计一个状态转换电路，出现三次抵消为0,需要使用两个bit位表示
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three;
        for (int num : nums) {
            // two的相应的位等于1，表示该位出现2次
            two |= (one & num);
            // one的相应的位等于1，表示该位出现1次
            one ^= num;
            // three的相应的位等于1，表示该位出现3次
            three = (one & two);
            // 如果相应的位出现3次，则该位重置为0
            two &= ~three;
            one &= ~three;
        }
        return one;
    }
}
// @lc code=end

