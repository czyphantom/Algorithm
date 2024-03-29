/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 * 题目：给定一个二叉树，找出其最小深度。
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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null) {
            return minDepth(root.right)+1;
        } else if(root.right == null) {
            return minDepth(root.left)+1;
        } else {
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
    }
}
// @lc code=end

