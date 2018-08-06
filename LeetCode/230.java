/**
 * 题目：给定一个二叉搜索树，编写一个函数来查找其中第k个最小的元素。
 * 难度：Medium
 * 思路：中序遍历
 */

// 递归
class Solution {
    private int count = 0;
    private int result = Integer.MIN_VALUE;

    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);
        return result;
    }

    private void solve(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        kthSmallest(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
        }
        kthSmallest(root.right, k);
    }
}

// 非递归
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        int count = 0;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                if (++count == k) {
                    return node.val;
                }
                p = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}