/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 * 题目：给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回null 。
 * 难度：Easy
 * 思路：先计算长度差，然后快慢指针
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);
        if (lenA > lenB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        int diffLen = Math.abs(lenA-lenB);
        ListNode p = headB;
        for (int i = 0;i < diffLen;i++) {
            p = p.next;
        }
        ListNode q = headA;
        while (q != null && q != p) {
            q = q.next;
            p = p.next;
        }
        return q;
    }

    private int getListLength(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }

    //简易写法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
// @lc code=end

