/**
 * 题目：给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 难度：Medium
 * 思路：回溯，重排列的生成可以通过交换两个数，再递归对后面的进行全排列完成。
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, nums, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, int[] nums, int cur){
        if(cur == nums.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int k : nums) {
                tmp.add(k);
            }
            ans.add(tmp);
        }
        else{
            for (int i = cur;i < nums.length;i++){
                swap(nums, cur, i);
                dfs(ans, nums, cur+1);
                swap(nums, cur, i);
            }
        }
    }
    private void swap(int[] nums, int x, int y){
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}