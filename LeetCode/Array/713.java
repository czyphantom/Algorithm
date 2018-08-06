/**
 * 题目：给定一个正整数数组 nums。找出该数组内乘积小于 k 的连续的子数组的个数。
 * 难度：Medium
 * 思路：双指针法
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) 
            return 0;
        int res = 0, prod = 1, left = 0;
        for (int i = 0; i < nums.length; ++i) {
            prod *= nums[i];
            while (prod >= k) 
                prod /= nums[left++];
            res += i - left + 1;
        }
        return res;
    }
}