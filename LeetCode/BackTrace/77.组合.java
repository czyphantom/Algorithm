/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 * 题目：给定两个整数n和k，返回范围[1, n]中所有可能的k个数的组合。
 * 难度：Medium
 * 思路：回溯
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), 1, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> current, int cur, int k, int n) {
        if (current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int i = cur;i <= n-(k-current.size())+1;i++) {
            current.add(i);
            dfs(result, current, i+1, k, n);
            current.remove(current.size()-1);
        }
    }
}
// @lc code=end

