/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 * 题目：给定一个可包含重复数字的序列nums，按任意顺序返回所有不重复的全排列。
 * 难度：Medium
 * 思路：回溯，就是要注意重复数字的问题
 */

// @lc code=start
class Solution {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums, ans, 0, perm);
        return ans;
    }

    public void backtrace(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrace(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
// @lc code=end

