/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 * 题目：给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 难度：Medium
 * 思路：公共祖先的值应该大介于两个节点的值之间
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        while (true) {
            if (p.val < result.val && q.val < result.val) {
                result = result.left;
            } else if (p.val > result.val && q.val > result.val) {
                result = result.right;
            } else {
                break;
            }
        }
        return result;
    }
}
// @lc code=end

