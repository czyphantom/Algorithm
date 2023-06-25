/*
 * @lc app=leetcode.cn id=41 lang=java
 *
 * [41] 缺失的第一个正数
 * 题目：给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 难度：Hard
 * 思路：一个正常的自然数数组是1，2，3，4。。。。，通过交换数组的位置让每个数都到正确的位置，最后遍历一遍即可找到未出现的最小蒸熟。
 */

// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length, i = 0;
        while(i < len) {
            //改种情况数字在正确的位置
            if (nums[i] == i+1) {
                i++;
            } else {
                if (nums[i] >= 1 && nums[i] <= len) {
                    int index = nums[i] - 1;
                    if (nums[index] == index + 1) {
                        i++;
                    } else {
                        swap(nums, i, index);
                    }
                } else {
                    i++;
                }
            }
        }
        for (int j = 0;j < nums.length;j++) {
            if (nums[j] != j+1) {
                return j+1;
            }
        }
        return len+1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end

