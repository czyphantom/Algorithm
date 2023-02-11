/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 * 题目：给你一个链表的头节点head，旋转链表，将链表每个节点向右移动k个位置。
 * 难度：Medium
 * 思路：拼接链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while (fast != null && count < k) {
            fast = fast.next;
            count++;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode rHead = slow.next;
        slow.next = null;
        fast.next = head;
        return rHead;
    }
}
// @lc code=end

