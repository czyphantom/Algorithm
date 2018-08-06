/**
 * 题目：给定n个整数，找出平均数最大且长度为k的连续子数组，并输出该最大平均数。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for(int i = 0;i < k;i++) {
            sum += nums[i];
        }
        double res = sum;
        for(int i = k;i < nums.length;i++){
            sum += nums[i]-nums[i-k];
            res = Math.max(res,sum);
        }
        return res/k;
    }
}