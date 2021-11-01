/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 * 题目：给你一个整数数组 nums ，其中元素已经按升序排列，请你将其转换为一棵高度平衡二叉搜索树。
 * 难度：Easy
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }
        int mid = (end-begin)/2+begin;
        TreeNode p = new TreeNode(nums[mid]);
        p.left = buildTree(nums, begin, mid-1);
        p.right = buildTree(nums, mid+1, end);
        return p;
    }
}
// @lc code=end

