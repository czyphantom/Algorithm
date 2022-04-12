/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 * 题目：给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 难度：Medium
 * 思路：用冗余节点
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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = next;
        }
        ListNode p = head;
        ListNode q = dummy.next;
        while (q != null) {
            ListNode r = q.next;
            ListNode s = p.next;
            q.next = p.next;
            p.next = q;
            p = s;
            q = r;
        }
    }
}
// @lc code=end

