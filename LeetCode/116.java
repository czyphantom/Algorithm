/**
 * 题目：给定一个二叉树，填充它的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将next指针设置为NULL。
 * 初始状态下，所有 next 指针都被设置为NULL。假设是一棵完美二叉树。
 * 难度：Medium
 * 思路：一层一层来
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }  
                cur = cur.next;
            }
            start = start.left;
        }
    }
}