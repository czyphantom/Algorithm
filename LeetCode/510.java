/**
 * 题目：找出中序遍历的后继中继
 * 难度：Medium
 * 思路：如果有右结点，那么下一个是右结点的最左结点，否则是父节点且是右父结点。
 */

class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        TreeLinkNode res = null;
        if (pNode.right != null) {
            res = pNode.right;
            while (res.left != null)
                res = res.left;
            return res;
        } else {
            while (pNode.next != null) {
                res = pNode.next;
                if (res.left == pNode)
                    return res;
                pNode = pNode.next;
            }
        }
        return null;
    }
}