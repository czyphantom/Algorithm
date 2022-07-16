/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 * 题目：路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中至多出现一次。该路径至少包含一个节点，且不一定经过根节点。
 * 路径和是路径中各节点值的总和。
 * 给你一个二叉树的根节点root ，返回其最大路径和。
 * 难度：Hard
 * 思路：见注释
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return res;
    }
    
    /**
     * 以该节点为根节点的子树中寻找以该节点为起点的一条路径，使得该路径上的节点值之和最大。
     */
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
// @lc code=end

