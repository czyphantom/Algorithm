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
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i]) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
// @lc code=end

