/**
 * 题目：给定两个整数n和k，返回1 ... n中所有可能的k个数的组合。
 * 难度：Medium
 * 思路：回溯
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), n, 1, k);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, int n, int cur, int k) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = cur;i <= n-(k-temp.size())+1;i++) {
            temp.add(i);
            dfs(result, temp, n, i+1, k);
            temp.remove(temp.size()-1);
        }
    }
}