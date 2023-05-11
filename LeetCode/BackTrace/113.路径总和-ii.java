/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 * 题目：给你二叉树的根节点root和一个整数目标和targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 难度：Medium
 * 思路：回溯
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(root, targetSum, result, new ArrayList<Integer>());
        return result;
    }

    private void backTrace(TreeNode current, int leftSum, List<List<Integer>> result, List<Integer> temp) {
        if (current == null) {
            return;
        }

        temp.add(current.val);
        leftSum -= current.val;
        if (current.left == null && current.right == null && leftSum == 0) {
            //这里不能return，因为递归到null之后会return，如果需要先return得先把temp里最后一个移除
            result.add(new ArrayList<Integer>(temp));
        }
        backTrace(current.left, leftSum, result, temp);
        backTrace(current.right,leftSum, result, temp);
        temp.remove(temp.size()-1);
    }
}
// @lc code=end

