/**
 * 题目：采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。空节点则用一对空括号 "()" 表示。
 * 而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        String result = t.val + "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (left == "" && right == "") {
            return result;
        }
        if (left == "") {
            return result + "()" + "(" + right + ")";
        }
        if (right == "") {
            return result + "(" + left + ")";
        }
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
