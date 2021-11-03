/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 * 题目：给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 难度：Easy
 * 思路：递归
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left)-getHeight(root.right) > 1)) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(root.left, root.right)+1;
    }
}
// @lc code=end

