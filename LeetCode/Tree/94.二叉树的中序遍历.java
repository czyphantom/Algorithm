/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 * 题目：给定一个二叉树的根节点 root ，返回它的中序遍历。
 * 难度：Easy
 * 思路：递归，
 * Morris中序遍历：如果节点x无左子节点，访问，并向右；如果有左子节点，找到左子树的最右节点
 * 即中序遍历的前驱节点y，如果前驱节点y的右孩子为空，则将其右孩子指向x，然后访问x
 * 左节点；如果右孩子不为空，将该节点的右孩子置空，处理该节点，并将x往左走
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    //非递归解法
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    return list;
                }
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
    }
}
// @lc code=end

