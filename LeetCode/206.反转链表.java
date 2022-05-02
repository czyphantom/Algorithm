/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 * 题目：给你单链表的头节点head ，请你反转链表，并返回反转后的链表。
 * 难度：Easy
 * 思路：递归或者迭代
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //迭代
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head.next;
        p.next = null;
        while (q != null) {
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    //递归
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
// @lc code=end

