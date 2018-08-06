/**
 * 题目：编写一个程序，找到两个单链表相交的起始节点。
 * 难度：Easy
 * 思路：水题
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0,len2 = 0;
        ListNode p = headA,q = headB;
        while(p != null) {
            p = p.next;
            len1++;
        }
        while(q != null) {
            q = q.next;
            len2++;
        }
        p = len1>len2 ? headA : headB;
        q = len1>len2 ? headB : headA;
        for(int i = 0;i < Math.abs(len1-len2);i++) {
            p = p.next;
        }
        while(p!=null && q!=null) {
            if(p == q)
                return p;
            p = p.next;
            q = q.next;
        }

        return null;
    }
}