/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
 * 题目：给定一个二叉树，返回其节点值自底向上的层序遍历。 
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * 难度：Medium
 * 思路：和层次遍历没有区别
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            int len = queue.size();
            for (int i = 0;i < len;i++) {
                TreeNode curNode = queue.poll();
                cur.add(curNode.val);
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            result.offerFirst(cur);
        }
        return result;
    }
}
// @lc code=end

