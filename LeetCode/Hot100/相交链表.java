/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 * 题目：给你两个单链表的头节点headA和headB，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回null。
 * 难度：Easy
 * 思路：基本的做法是求两个链表的长度，然后快慢指针，标答用的也是快慢指针，但是其中一个遍历完之后重新从另一个链表的头节点开始执行，直到两个指针相等
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
        int aLen = getLen(headA);
        int bLen = getLen(headB);
        int diffLen = Math.abs(aLen-bLen);
        if (aLen > bLen) {
            ListNode p = headA;
            headA = headB;
            headB = p;
        }
        ListNode b = headB;
        for (int i = 0;i < diffLen;i++) {
            b = b.next;
        }
        ListNode a = headA;
        while (a != b  && a != null && b != null) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private int getLen(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }

    //标答
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

