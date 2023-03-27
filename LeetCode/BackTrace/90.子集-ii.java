/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 * 题目：给你一个整数数组nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backTrace(nums, 0, result, new ArrayList<>());
        return result;
    }

    private void backTrace(int[] nums, int cur, List<List<Integer>> result, List<Integer> curList) {
        boolean flag = false;
        for (int i = cur;i < nums.length;i++) {
            if (i >= 1 && flag && nums[i] == nums[i-1]) {
                continue;
            }
            curList.add(nums[i]);
            flag = true;
            result.add(new ArrayList<>(curList));
            backTrace(nums, i+1, result, curList);
            curList.remove(curList.size()-1);
        }
    }
}
// @lc code=end

