/**
 * 题目：给定一个二叉树，在树的最后一行找到最左边的值。
 * 难度：Medium
 * 思路：维护一个当前的最左值，使用递归即可。
 */

class Solution {
    private int res = 0, h = 0;

    public int findBottomLeftValue(TreeNode root) {
        solve(root, 1);
        return res;
    }

    public void solve(TreeNode root, int depth) {
        if (h < depth) {
            res = root.val;
            h = depth;
        }
        if (root.left != null)
            solve(root.left, depth + 1);
        if (root.right != null)
            solve(root.right, depth + 1);
    }
}