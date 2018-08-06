/**
 * 题目：给定一个二进制数组， 计算其中最大连续1的个数。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
        	count++;
        	result = Math.max(count, result);
            }
            else 
                count = 0;
        }
        
        return result;
    }
}