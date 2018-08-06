/**
 * 题目：同116，但不是完美二叉树。
 * 难度：Medium
 * 思路：通过冗余节点
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode cur = dummy,head = root;
        while (root != null) {
            if (root.left != null) {
                cur.next = root.left;
            }
            if (root.right != null) {
                cur.next = root.right;
            }
            root = root.next;
            if (root != null) {
                cur = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
        return head;
    }
}