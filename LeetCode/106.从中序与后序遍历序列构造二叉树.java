/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 * 题目：根据一棵树的中序遍历与后序遍历构造二叉树。
 * 难度：Medium
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
    private HashMap<Integer, Integer> hash;
    class Index {
         int index;
         public Index(int i) {
             this.index = i;
         }
    }
     
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         int n = postorder.length;
         hash = new HashMap<Integer, Integer>();
         Index curRoot = new Index(n-1);
         for(int i = 0; i < n; hash.put(inorder[i], i), i++);
         return build(inorder, postorder, 0, n-1, curRoot);
    }
     
    private TreeNode build(int[] in, int[] post, int start, int end, Index postIndex) {
        if(start > end) {
            return null;
        }
        TreeNode root = new TreeNode(post[postIndex.index]);
        postIndex.index--;
         
        if(start == end) {
            return root;
        }
         
        int found = hash.get(root.val);
         
        root.right = build(in, post, found + 1, end, postIndex);
        root.left = build(in, post, start, found - 1, postIndex);
         
        return root;
     }
}
// @lc code=end

