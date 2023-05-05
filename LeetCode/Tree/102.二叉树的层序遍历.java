/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 * 题目：给你一个二叉树，请你返回其按层序遍历得到的节点值。（即逐层地，从左到右访问所有节点）。
 * 难度：Medium
 * 思路：队列
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode p = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> cur = new ArrayList<>();
            Queue newQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                cur.add(temp.val);
                if (temp.left != null) {
                    newQueue.offer(temp.left);
                }
                if (temp.right != null) {
                    newQueue.offer(temp.right);
                }
            }
            queue = newQueue;
            result.add(cur);
        }
        return result;
    }
}
// @lc code=end

