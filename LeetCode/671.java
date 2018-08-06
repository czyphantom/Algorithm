/**
 * 题目：给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出-1。
 * 难度：Easy
 * 思路：递归
 */

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left == null) {
            return -1;
        }
        int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;
        return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
    }
}