/**
 * 题目：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序
 * 插入的位置。你可以假设数组中无重复元素。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int searchInsert(int[] A, int target) {
        if (A == null) {
            return -1;
        }
        int i;
        for (i = 0; i < A.length; i++) {
            if (A[i] >= target) {
                return i;
            }
        }
        return i;
    }
}