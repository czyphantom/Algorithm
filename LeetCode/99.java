/**
 * 题目：二叉搜索树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * 难度：Hard
 * 思路：中序遍历
 */

class Solution {
    TreeNode t1, t2, pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null && pre.val > root.val) {
            if (t1 == null) {
                t1 = pre;
            }
            t2 = root;
        }
        pre = root;
        inorder(root.right);
    }
}