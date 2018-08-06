/**
* 题目：给定一个数组和一个数，求子数组和大于等于该数的最小长度
* 难度：Medium
* 思路：双指针
*/

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0,j = 0;
        while(i < nums.length && j < nums.length) {
            while(j < nums.length && sum < s) {
                sum += nums[j++];
            }
            while(i <= j && sum >= s) {
                min = Math.min(min,j-i+1);
                sum -= nums[i++];
            }
        }
        if(min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}

