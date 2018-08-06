/**
 * 题目：给定长度为2n的数组, 你的任务是将这些数分成n对, 例如(a1, b1), (a2, b2), ..., (an, bn)，使得从1到n的
 * min(ai, bi) 总和最大。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}