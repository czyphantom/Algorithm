/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 * 题目：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
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
    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode result = reverseList(head.next);
        if (p != null) {
            p.next = head;
            head.next = null;
        }
        return result;
    }

    //迭代解法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
// @lc code=end

