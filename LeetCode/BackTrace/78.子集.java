/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 * 题目：给你一个整数数组nums ，数组中的元素互不相同 。返回该数组所有可能的子集（幂集）。
 * 难度：Medium
 * 思路：回溯，和77类似
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void backTrace(int[] nums, List<List<Integer>> result, List<Integer> list, int cur) {
        result.add(new ArrayList<Integer>(list));
        for (int i = cur;i < nums.length;i++) {
            list.add(nums[i]);
            backTrace(nums, result, list, i+1);
            list.remove(list.size()-1);
        }
    }

    //官方解法
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }
}
// @lc code=end

