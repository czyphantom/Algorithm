/**
* 题目：在一个没有重复数字的数组中，找出和为给定数的所有组合，每个数字都可以用多次。
* 难度：Medium
* 思路：回溯
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        findResults(res,new ArrayList<>(),candidates,target,0);
        return res;
    }
    
    private void findResults(List<List<Integer>> res,List<Integer> tmp,int[] candidates,int target,int start) {
        if(target > 0) {
            for(int i = start;i < candidates.length;i++) {
                tmp.add(candidates[i]);
                findResults(res, tmp, candidates, target-candidates[i], i);
                tmp.remove(tmp.size()-1);
            }
        } else if(target == 0) {
            res.add(new ArrayList<>(tmp));
        }
    }
}