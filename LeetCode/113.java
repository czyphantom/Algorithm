/**
 * 题目：给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 难度：Medium
 * 思路：回溯
 */

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        solve(root, sum, new ArrayList<>(), res);
        return res;
    }
 
    private void solve(TreeNode root, int sum, List<Integer> list, List<List<Integer>> res) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }
        solve(root.left, sum, list, res);
        solve(root.right, sum, list, res);
        list.remove(list.size()-1);
    }
}