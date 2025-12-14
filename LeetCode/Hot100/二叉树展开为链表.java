/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 * 题目：给你二叉树的根结点root，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用TreeNode ，其中right子指针指向链表中下一个结点，而左子指针始终为null 
 * 展开后的单链表应该与二叉树先序遍历顺序相同。
 * 难度：Medium
 * 思路：我的解法是展开时，如果左右节点都存在时，将右节点插入到左节点前序遍历的最后一个节点的右边即可。官解的思路也差不多
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null) {
            flatten(root.right);
            return;
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            return;
        }
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode position = getLastNode(root.right);
        position.right = right;
        flatten(root.right);
    }

    private TreeNode getLastNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (true) {
            while (node.right != null) {
                node = node.right;
            }
            if (node.left != null) {
                node = node.left;
            }
            if (node.left == null && node.right == null) {
                return node;
            }
        }

        return node;
    }

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
// @lc code=end

