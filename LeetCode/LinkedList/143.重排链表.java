/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 * 题目：给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 难度：Medium
 * 思路：先找到链表的中点，将后半部分链表反转，然后和前半部分链表合并，使用一个冗余节点更方便一点
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
        ListNode slow = head,fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode p = slow;
        while (p != null) {
            ListNode temp = dummy.next;
            dummy.next = p;
            ListNode next = p.next;
            p.next = temp;
            p = next;
        }

        ListNode r = dummy.next,q = head;
        while (r != null) {
            ListNode qNext = q.next;
            ListNode rNext = r.next;
            q.next = r;
            r.next = qNext;
            q = qNext;
            r = rNext;
        }
        q.next = null;
    }
}
// @lc code=end

