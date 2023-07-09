/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 * 题目：给定一个无重复元素的数组candidates和一个目标数target ，找出candidates中所有可以使数字和为target的组合。
 * candidates中的数字可以无限制重复被选取。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(candidates, 0, target, result, new ArrayList<Integer>());
        return result;
    }

    private void backTrace(int[] candidates, int cur, int target, List<List<Integer>> result, List<Integer> temp) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (cur >= candidates.length || target < 0) {
            return;
        }
        for (int i = cur;i < candidates.length;i++) {
            temp.add(candidates[i]);
            backTrace(candidates, i, target-candidates[i], result, temp);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

