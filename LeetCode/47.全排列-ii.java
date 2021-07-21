/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 题目：给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 难度：Medium
 * 思路：回溯，就是要注意重复数字的问题
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<Integer> appear = new HashSet<>();
        for (int i = cur;i < nums.length;i++) {
            if (appear.add(nums[i])) {
                swap(nums, cur, i);
                backTrace(result, nums, cur+1);
                swap(nums, cur, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

