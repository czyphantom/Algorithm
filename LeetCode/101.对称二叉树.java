/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 * 题目：给定一个二叉树，检查它是否是镜像对称的。
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left,TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if(left != null && right != null) {
            if(left.val != right.val) {
                return false;
            }
        }
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }
}
// @lc code=end

