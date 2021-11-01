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
        if(preorder == null || inorder == null || (preorder.length != inorder.length)) {
            return null;
        }
        return buildTree(preorder, inorder, 0, 0, preorder.length);
    }

    TreeNode buildTree(int[] preorder, int[] inorder, int from1, int from2, int len) {
        if (len == 0) {
            return null;
        }

        if(len == 1) {
            return new TreeNode(preorder[from1]);
        }

        TreeNode node = new TreeNode(preorder[from1]);
        int index = findIndex(inorder, from2, from2 + len, preorder[from1]); 
        if (index >= 0) {
            node.left = buildTree(preorder, inorder, from1 + 1, from2,index - from2);
            node.right = buildTree(preorder, inorder, from1 + index - from2 + 1, index + 1, len - index + from2 -1);
        }

        return node;
    }

    int findIndex(int[] array, int from, int to, int value) {
        for(int i = from; i < to; i++) {
            if(array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

