/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 * 题目：给定一个无重复元素的数组candidates和一个目标数target ，找出candidates中所有可以使数字和为target的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        backTrace(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backTrace(List<List<Integer>> result, List<Integer> current, int[] candidates, int left, int cur) {
        if (left < 0) {
            return;
        }
        if (left == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = cur;i < candidates.length;i++) {
            current.add(candidates[i]);
            backTrace(result, current, candidates, left-candidates[i], i);
            current.remove(current.size()-1);
        }
    }
}
// @lc code=end

