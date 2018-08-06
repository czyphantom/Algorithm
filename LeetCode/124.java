/**
 * 题目：给定一个非空二叉树，返回其最大路径和。本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 难度：Hard
 * 思路：回溯
 */

class Solution {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }
    
    private int getMax(TreeNode r) {
        if(r == null) {
            return 0;
        }
        int left = Math.max(0, getMax(r.left)); 
        int right = Math.max(0, getMax(r.right));
        res = Math.max(res, r.val + left + right);
        return Math.max(left, right) + r.val;
    }
}