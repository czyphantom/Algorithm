/**
* 题目：反转二叉树
* 思路：如果结点不为空则交换左右子结点，然后递归反转左子树和右子树
*/

public class Solution {
    public void Mirror(TreeNode root) {
        if(root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
