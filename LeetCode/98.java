/**
 * 题目：给定一个二叉树，判断其是否是一个有效的二叉搜索树。假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 难度：Medium
 * 思路：递归，注意要判断与左节点的最大值和右节点的最小值对比
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right==null)) {
            return true;
        }
        TreeNode leftTemp = root.right,rightTemp = root.left;
        while (leftTemp != null && leftTemp.left != null) {
            leftTemp = leftTemp.left;
        }
        while(rightTemp != null && rightTemp.right != null) {
            rightTemp = rightTemp.right;
        }
        if(root.left != null) {
            if(root.val <= root.left.val || root.val <= rightTemp.val) {
                return false;
            }
        }
        if(root.right != null) {
            if(root.val >= root.right.val || root.val >= leftTemp.val) {
                return false;
            }
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }
} 

class Solution2 {
    int last = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
        if (root == null) {
            return true;
        }
        if(!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= last) {
            return false;
        }
        last = root.val;
        if(!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}