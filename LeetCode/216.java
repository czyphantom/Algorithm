/**
* 题目：找出所有相加之和为n的k个数的组合。组合中只允许含有1-9的正整数，并且每种组合中不存在重复的数字。
* 难度：Medium
* 思路：深度优先搜索
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        find(1, n, new int[k], 0, results);
        return results;
    }
    
    private void find(int from, int sum, int[] nums, int step, List<List<Integer>> results) {
        if (sum < 0) {
            return;
        }
        if (step == nums.length) {
            if (sum == 0) {
                Integer[] n = new Integer[nums.length];
                for(int i = 0; i < step; i++) {
                    n[i] = nums[i];
                }
                results.add(Arrays.asList(n));
            }
            return;
        }
        for(int i = from; i < 10 && i <= sum; i++) {
            nums[step] = i;
            find(i+1, sum-i, nums, step+1, results);
        }
    }
}