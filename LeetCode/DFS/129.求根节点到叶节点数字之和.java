/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 * 题目：给你一个二叉树的根节点root，树中每个节点都存放有一个0到9之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径1 -> 2 -> 3表示数字123。
 * 计算从根节点到叶节点生成的所有数字之和。
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
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode node, int cur) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result += cur * 10 + node.val;
            return;
        }
        if (node.left != null) {
            dfs(node.left, cur*10+node.val);
        }
        if (node.right != null) {
            dfs(node.right, cur*10+node.val);
        }
    }
}
// @lc code=end

