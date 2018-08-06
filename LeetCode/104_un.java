/**
 * 题目：给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}