/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 * 题目：根据一棵树的中序遍历与后序遍历构造二叉树。
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
         return buildTree(postorder,0, postorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] postorder, int postBegin, int postEnd, int[] inorder, int inBegin, int inEnd) {
        if (postBegin > postEnd || postBegin < 0 || postEnd >= postorder.length) {
            return null;
        }
        int rootValue = postorder[postEnd];
        int rootIndex = findValue(rootValue, inorder, inBegin, inEnd);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(postorder, postBegin, postBegin+rootIndex-inBegin-1, inorder, inBegin, rootIndex-1);
        root.right = buildTree(postorder,postBegin+rootIndex-inBegin, postEnd-1, inorder, rootIndex+1, inEnd);
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

