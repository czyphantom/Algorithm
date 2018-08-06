/**
 * 题目：给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 难度：Medium
 * 思路：只要知道环的长度即可，在用双指针相遇后，固定一个，让另一个走即可。
 */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;

        int nodesInLoop = 1;
        ListNode p1 = meetingNode;
        while (p1.next != meetingNode) {
            p1 = p1.next;
            ++nodesInLoop;
        }
        p1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private ListNode meetingNode(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head;
        ListNode q = head;
        while (q != null) {
            p = p.next;
            q = q.next;
            if (q != null)
                q = q.next;
            else
                break;
            if (q == p)
                return p;
        }
        return null;
    }
}