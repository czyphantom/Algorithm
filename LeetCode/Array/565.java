

/**
 * 题目大意： 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到并返
 * 回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以
 * 下的规则。假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该
 * 是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元
 * 素。
 * 难度： Medium
 * 思路： 每次查找的时候让该位置的值失效（比如设为-1) 
 */

class Solution {
    public int arrayNesting(int[] nums) {
        int max = -1;      
        int len = nums.length;
        for(int i = 0;i < len;i++) {
            int j = i;
            int count = 1;
            while(nums[j] != len && nums[j] != i) {
                count++;
                int temp = nums[j];
                nums[j] = len;
                j = temp;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}