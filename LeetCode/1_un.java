/**
 * 题目：给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。你可以假设每个输入只对应一种答案，且同样的元素
 * 不能被重复利用。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0;i < nums.length;i++) {
            for(int j =i+1;j < nums.length;j++) {
                if(nums[j] == target-nums[i]) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result; 
    }
}