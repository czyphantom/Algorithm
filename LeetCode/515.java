/**
 * 题目：在二叉树的每一行中找到最大的值。
 * 难度：Medium
 * 思路：深度优先搜索
 */

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        solve(root, res, 0);
        return res;
    }

    private void solve(TreeNode root, List<Integer> res, int depth) {
        if (root == null) {
            return;
        }
        if (depth == res.size()) {
            res.add(root.val);
        } else {
            res.set(depth, Math.max(res.get(depth), root.val));
        }
        solve(root.left, res, depth + 1);
        solve(root.right, res, depth + 1);
    }
}