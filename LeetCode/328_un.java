/**
 * 题目：给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode dummy = new ListNode(-1);
        dummy.next = q;
        while (p.next != null && q != null && q.next != null) {
            ListNode r = q.next;
            p.next = r;
            q.next = r.next;
            p = r;
            q = r.next;
        }
        p.next = dummy.next;
        return head;
    }
}