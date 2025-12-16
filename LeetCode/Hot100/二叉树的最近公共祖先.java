/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 * 题目：给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 难度：Medium
 * 思路：我的解法是存储p，q的路径，然后寻找最近的一个相同路径节点，标答
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        getPath(root, p, pPath);
        getPath(root, q, qPath);
        int i = 0;
        while (i < pPath.size() && i < qPath.size()) {
            if (pPath.get(i) != qPath.get(i)) {
                break;
            }
            i++;
        }
        return pPath.get(i-1);
    }

    private boolean getPath(TreeNode cur, TreeNode p, List<TreeNode> path) {
        if (cur == null) {
            return false;
        }
        path.add(cur);
        if (cur == p) {
            return true;
        }
        boolean leftResult = getPath(cur.left, p, path);
        if (leftResult) {
            return true;
        }
        boolean rightResult = getPath(cur.right, p, path);
        if (rightResult) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null || root == p || root == q) {
            return root;
       }
       //右子树中找p，q的祖先    
       TreeNode r = lowestCommonAncestor(root.right , p , q);
       //左子树中找p，q的祖先
       TreeNode l = lowestCommonAncestor(root.left , p , q);
       return l == null ? r : (r == null ? l : root);
   }
}
// @lc code=end

