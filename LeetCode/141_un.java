/**
 * 题目：给定一个链表，判断链表中是否有环。
 * 难度：Easy
 * 思路：水题
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode p = head;
        ListNode q = head;
        while(q != null) {
            p = p.next;
            q = q.next;
            if(q != null)
                q = q.next;
            else
                break;
            if(q == p)
                return true;
        }

        return false;
    }
}