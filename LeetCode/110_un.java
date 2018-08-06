/**
 * 题目：给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        if(Math.abs(len(root.left)-len(root.right)) > 1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
            
    }

    private int len(TreeNode root) {
        if(root == null)
            return 0;
        else 
            return Math.max(len(root.left),len(root.right))+1;
    }
}