/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 * 题目：给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。 
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        backTrace(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void backTrace(List<List<Integer>> result, List<Integer> temp, int[] candidates, int left, int cur) {
        if (left == 0) {
            result.add(new ArrayList<Integer>(temp));
        }
        if (left < 0) {
            return;
        }
        for (int i = cur;i < candidates.length;i++) {
            if(i > cur && candidates[i] == candidates[i-1]) {
                continue;
            }
            temp.add(candidates[i]);
            backTrace(result, temp, candidates, left-candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

