/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 * 题目：给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。 
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if(i > cur && candidates[i] == candidates[i-1]) {
                continue;
            }
            temp.add(candidates[i]);
            backTrace(candidates, i+1, target-candidates[i], result, temp);
            temp.remove(temp.size()-1);
        }
    }
}
// @lc code=end

