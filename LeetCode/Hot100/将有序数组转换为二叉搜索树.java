/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 * 题目：给你一个整数数组nums，其中元素已经按升序排列，请你将其转换为一棵平衡二叉搜索树。
 * 难度：Easy
 * 思路：递归即可


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
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayToBST(nums, 0, nums.length-1);
    }

    private TreeNode arrayToBST(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }
        int mid = (end-begin)/2+begin;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = arrayToBST(nums, begin, mid-1);
        node.right = arrayToBST(nums,mid+1, end);
        return node;
    }
}
// @lc code=end

