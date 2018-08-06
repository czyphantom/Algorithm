/**
 * 题目：给定一个二叉树，找出其最小深度。最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        else {
            if(root.left == null)
                return minDepth(root.right)+1;
            else if(root.right == null)
                return minDepth(root.left)+1;
            else
                return Math.min(minDepth(root.left),minDepth(root.right))+1;
        }
    }
}