/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 * 题目：给定一个不含重复数字的数组nums ，返回其所有可能的全排列 。你可以按任意顺序返回答案。
 * 难度：Medium
 * 思路：回溯 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(result, nums, 0);
        return result;
    }

    private void backTrace(List<List<Integer>> result, int[] nums, int cur) {
        if(cur == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int num: nums) {
                tmp.add(num);
            }
            result.add(tmp);
        }
        for (int i = cur;i < nums.length;i++) {
            swap(nums, cur, i);
            backTrace(result, nums, cur+1);
            swap(nums, cur, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

