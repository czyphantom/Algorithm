/**
 * 题目：给定两个非空二叉树s和t，检验s中是否包含和t具有相同结构和节点值的子树。s的一个子树包括s的一个节点和这个节点的所有子孙。s也可以看做它自身的一棵子树。
 * 难度：Easy
 * 思路：递归，不过有一种更好的解法是序列化二叉树然后查看序列字符串是否存在包含关系。
 */

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        boolean res = false;
        if (s != null && t != null) {
            if (s.val == t.val)
                res = isSub(s, t);
            if (!res)
                res = isSubtree(s.left, t) || isSubtree(s.right, t);
        }
        return res;
    }

    private boolean isSub(TreeNode s, TreeNode t) {
        if (s == null && t != null)
            return false;
        if (s != null && t == null)
            return false;
        if (t == null && s == null)
            return true;
        if (s.val != t.val)
            return false;
        return isSub(s.left, t.left) && isSub(s.right, t.right);
    }
}