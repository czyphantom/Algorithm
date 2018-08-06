/**
 * 题目：给定一个二叉搜索树，同时给定最小边界L和最大边界R。
 * 通过修剪二叉搜索树，使得所有节点的值在[L,R]中(R>=L) 。
 * 你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 * 难度：Easy
 * 思路：递归
 */

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}