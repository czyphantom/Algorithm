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

        List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}
// @lc code=end

