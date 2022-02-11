/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 * 题目：给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和。
 * 难度：Medium
 * 思路：dfs
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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return result;
    }

    private void solve(TreeNode current, int cur) {
        if (current == null) {
            return;
        }
        if (current.left == null && current.right == null) {
            result += cur*10 + current.val;
            return;
        }
        if (current.left != null) {
            solve(current.left, cur*10 + current.val);
        }
        if (current.right != null) {
            solve(current.right, cur*10 + current.val);
        }
    }
}
// @lc code=end

