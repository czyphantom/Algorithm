/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 * 题目：给定一棵树的前序遍历preorder与中序遍历inorder。请构造二叉树并返回其根节点。
 * 难度：Medium
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        if (preBegin > preEnd || preBegin < 0 || preEnd >= preorder.length) {
            return null;
        }
        int rootValue = preorder[preBegin];
        int rootIndex = findValue(rootValue, inorder, inBegin, inEnd);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(preorder, preBegin+1, preBegin+rootIndex-inBegin, inorder, inBegin, rootIndex-1);
        root.right = buildTree(preorder,preBegin+rootIndex-inBegin+1, preEnd, inorder, rootIndex+1, inEnd);
        return root;
    }

    private int findValue(int value, int[] array, int begin, int end) {
        for (int i = begin;i <= end;i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

