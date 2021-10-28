/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 * 题目：给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 难度：Medium
 * 思路：利用中序遍历是有序的来判断
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
    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
        checkBST(root);
        return result;
    }

    private void checkBST(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.val >= root.val) {
            result = false;
            return;
        }
        TreeNode leftMax = getLeftMax(root);
        if (leftMax != null && leftMax.val >= root.val) {
            result = false;
            return;
        }
        if (root.right != null && root.right.val <= root.val) {
            result =false;
            return;
        } 
        TreeNode rightMin = getRightMin(root);
        if (rightMin != null && rightMin.val <= root.val) {
            result = false;
            return;
        }
        checkBST(root.left);
        checkBST(root.right);
    }

    private TreeNode getLeftMax(TreeNode root) {
        if (root != null && root.left != null) {
            TreeNode p = root.left.right;
            while (p != null && p.right != null) {
                p = p.right;
            }
            return p;
        }
        return null;
    }

    private TreeNode getRightMin(TreeNode root) {
        if (root != null && root.right != null) {
            TreeNode p = root.right.left;
            while (p != null && p.left != null) {
                p = p.left;
            }
            return p;
        }
        return null;
    }

    int last = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if (root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= last) {
            return false;
        }
        last = root.val;
        if(!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
// @lc code=end

