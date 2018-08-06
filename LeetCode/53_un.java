/**
 * 题目：给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 难度：Easy
 * 思路：动态规划
 */

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            throw new IllegalArgumentException();
        }
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i : nums) {
            if (curSum <= 0){
                curSum = i;
            }
            else {
                curSum += i;
            }
            if (max < curSum) {
                max = curSum;
            }
        }

        return max;
    }
} 