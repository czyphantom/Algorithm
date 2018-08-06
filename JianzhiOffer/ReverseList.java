/**
* 题目：反转链表
* 思路：头插法
*/

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode p = head;
        ListNode q = head.next;
        p.next = null;
        while(q != null) {
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        return p;
    }
}
