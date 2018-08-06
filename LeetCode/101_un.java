/**
 * 题目：给定一个二叉树，检查它是否是镜像对称的。
 * 难度：Easy
 * 思路：
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left,TreeNode right) {
        if(left==null && right==null)
            return true;
        if((left==null && right!=null) || (left!=null && right==null))
            return false;
        if(left!=null && rihgt!=null) {
            if(left.val != right.val)
                return false;
        }
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }
}