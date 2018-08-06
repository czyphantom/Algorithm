/**
 * 题目：给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。注意：两个节点之间的路径长度由它们之间的边数表示。
 * 难度：Easy
 * 思路：深度优先搜索
 */

class Solution {
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) {
            dfs(root, res);
        }
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0; 
        int r = node.right != null ? dfs(node.right, res) : 0; 
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0; 
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0; 
        res[0] = Math.max(res[0], resl + resr); 
        return Math.max(resl, resr);
    }
}