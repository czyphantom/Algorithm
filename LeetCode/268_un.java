/**
 * 题目：给定一个包含0, 1, 2, ..., n中n个数的序列，找出0 .. n中没有出现在序列中的那个数。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}