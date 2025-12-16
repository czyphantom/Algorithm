/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 * 题目：给定两个整数数组preorder和inorder，其中preorder是二叉树的先序遍历，inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 难度：Medium
 * 思路：递归，先序遍历的第一个节点是根节点，在中序遍历序列中找出来，然后找左右子树
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
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        if (preBegin > preEnd || inBegin > inEnd || preEnd < 0 || preBegin > preorder.length-1 || inBegin < 0 || inEnd > inorder.length-1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preBegin]);
        int rootIndex = findInInorder(preorder[preBegin], inorder, inBegin, inEnd);
        root.left = buildTree(preorder, inorder, preBegin+1, preBegin+rootIndex-inBegin, inBegin, rootIndex-1);
        root.right = buildTree(preorder, inorder, preBegin+rootIndex-inBegin+1, preEnd, rootIndex+1, inEnd);
        return root;
    }

    private int findInInorder(int target, int[] nums, int begin, int end) {
        for (int i = begin;i <= end;i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

