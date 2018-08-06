/**
 * 题目：给定一个长度为n的整数数组，你的任务是判断在最多改变1个元素的情况下，该数组能否变成一个非递减数列。我们是这
 * 样定义一个非递减数列的：对于数组中所有的i(1<=i<n)，满足array[i]<=array[i + 1]。
 * 难度：Easy
 * 思路：水题
 */

 class Solution {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1;i<nums.length && cnt<=1;i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2]<=nums[i]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return cnt <= 1; 
    }
 }