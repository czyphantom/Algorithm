/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 * 题目：给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * 难度：Medium
 * 思路：用一个冗余节点放在最前面，减少分类讨论
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        int len = getLen(head);
        ListNode p = dummy;
        for (int i = 0;i < len - n;i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    private int getLen(ListNode head) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
}
// @lc code=end

