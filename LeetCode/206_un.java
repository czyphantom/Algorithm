/**
 * 题目：反转一个单链表。
 * 难度：Easy
 * 思路：水题
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode p = head.next;
        head.next = null;
        ListNode q = head;
        while(p != null) {
            ListNode temp = p.next;
            p.next = q;
            q = p;
            p = temp;
        }

        return q;
    }
}

//递归
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}