/**
 * 题目：给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 难度：Easy
 * 思路：水题
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return root;
        if(root.val == val){
            return root;
        }
        else{
            return val<root.val? searchBST(root.left,val):searchBST(root.right,val);
        }
    }
}