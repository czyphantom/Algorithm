/**
 * 题目：给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 难度：Easy
 * 思路：右-根-左遍历二叉树。
 */

class Solution {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        solve(root);
        return root;
    }

    private void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        solve(root.right);
        root.val += sum;
        sum = root.val;
        solve(root.left);
    }
}