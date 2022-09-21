/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数N个结点
 * 题目：给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * 难度：Medium
 * 思路：快慢指针
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
        ListNode fast = dummy;
        for (int i = 0;i < n;i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode slow = dummy;
        while (fast != null  && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next == null ? null : slow.next.next;
        return dummy.next;
    }
}
// @lc code=end

