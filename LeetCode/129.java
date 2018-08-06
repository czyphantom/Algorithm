/**
 * 题目：给定一个二叉树，它的每个结点都存放一个0-9的数字，每条从根到叶子节点的路径都代表一个数字。计算从根到叶子节点生成的所有数字之和。
 * 难度：Medium
 * 思路：递归
 */

class Solution {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        solve(root, 0);
        return sum;
    }

    private void solve(TreeNode root, int cur) {
        if (root != null) {
            cur = cur * 10 + root.val;
            if (root.left == null && root.right == null) {
                sum += cur;
            } else {
                solve(root.left, cur);
                slolve(root.right, cur);
            }
        }
    }
}