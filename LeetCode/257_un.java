/**
 * 题目：给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 难度：Easy
 * 思路：深度优先搜索
 */

class Solution {
    private List<String> resultList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        findPaths(root, root.val + "");
        return resultList;
    }

    private void findPaths(TreeNode node, String path) {
        if (node.left == null && node.right == null) {
            resultList.add(path);
        }
        if (node.left != null) {
            findPaths(node.left, path + "->" + node.left.val);
        }
        if (node.right != null) {
            findPaths(node.right, path + "->" + node.right.val);
        }
    }
}