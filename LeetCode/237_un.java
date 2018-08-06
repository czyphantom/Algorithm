/**
 * 题目：请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = null;
        while (node.next != null) {
            if (node.next.next == null) {
                pre = node;
            }
            node.val = node.next.val;
            node = node.next;
        }
        pre.next = null;
    }
}