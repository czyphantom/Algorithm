/**
 * 题目：给定一个单链表 L：L0→L1→…→Ln-1→Ln，将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 难度：Medium
 * 思路：使用冗余节点
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = next;
        }
        ListNode p = head;
        ListNode q = dummy.next;
        while (q != null) {
            ListNode r = q.next;
            ListNode s = p.next;
            q.next = p.next;
            p.next = q;
            p = s;
            q = r;
        }
    }
}