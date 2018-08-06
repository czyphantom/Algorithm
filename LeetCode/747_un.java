/**
 * 题目：在一个给定的数组nums中，总是存在一个最大元素。查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public int dominantIndex(int[] nums) {
        if (nums==null || nums.length==0) {
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] > max) {
                max = nums[i];
                max2 = max;
                maxIndex = i;
            } else if (nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max2*2 <= max) ? maxIndex : -1;

    }
}