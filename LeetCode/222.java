/**
 * 题目：给出一个完全二叉树，求出该树的节点个数。 
 * 难度：Medium 
 * 思路：递归
 */

class Solution {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth)
            return (1 << leftDepth) - 1;
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int rightDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.right;
            dep++;
        }
        return dep;
    }

    private int leftDepth(TreeNode root) {
        int dep = 0;
        while (root != null) {
            root = root.left;
            dep++;
        }
        return dep;
    }
}