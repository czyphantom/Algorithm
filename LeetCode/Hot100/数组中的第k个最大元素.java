/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 * 题目：给定整数数组nums和整数k，请返回数组中第k个最大的元素。
 * 请注意，你需要找的是数组排序后的第k个最大的元素，而不是第k个不同的元素。
 * 你必须设计并实现时间复杂度为O(n)的算法解决此问题。
 * 难度：Medium
 * 思路：快速排序的思想
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] _nums, int k) {
        int n = _nums.length;
        return quickselect(_nums, 0, n - 1, n - k);
    }

    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[k];
        }
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++; 
            }while (nums[i] < x);
            do {
                j--;
            } while (nums[j] > x);
            if (i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) {
            return quickselect(nums, l, j, k);
        }
        else {
            return quickselect(nums, j + 1, r, k);
        }
    }
}
// @lc code=end

