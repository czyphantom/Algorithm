/**
 * 题目：给定一个二叉树，根节点为第1层，深度为1。在其第d层追加一行值为v的节点。
 * 添加规则：给定一个深度值d（正整数），针对深度为d-1层的每一非空节点N，为N创建两个值为v的左子树和右子树。
 * 将N原先的左子树，连接为新节点v的左子树；将N原先的右子树，连接为新节点v的右子树。
 * 如果d的值为1，深度d-1不存在，则创建一个新的根节点v，原先的整棵树将作为v的左子树。
 * 难度：Medium
 * 思路：DFS
 */

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d < 2) {
            TreeNode newRoot = new TreeNode(v);
            if (d == 0) {
                newRoot.right = root;
            } else {
                newRoot.left = root;
            }
            return newRoot;
        }
        if (root == null) {
            return null;
        }
        root.left = addOneRow(root.left, v, d == 2 ? 1 : d-1);
        root.right = addOneRow(root.right, v, d == 2 ? 0 : d-1);
        return root;
    }
}