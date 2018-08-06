/**
 * 题目：给定一个链表，删除链表的倒数第n个节点，并且返回链表的头结点。
 * 难度：Medium
 * 思路：实际上就是要求倒数第n+1个节点，注意删除的节点如果是头节点的情况。
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for(int i = 0;i <= n ;i++) {
            if(q != null)
                q = q.next;
            else 
                return head.next;
        }
        while(q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}