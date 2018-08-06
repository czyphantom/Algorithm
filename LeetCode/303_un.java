/**
 * 题目：给定一个整数数组nums，求出数组从索引i到j(i ≤ j)范围内元素的总和，包含i,j两点。
 * 难度：Easy
 * 思路：动态规划水题
 */

class NumArray {
    
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0) {
            return;
        }
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] += sums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}