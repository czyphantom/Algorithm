/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 * 题目：给你一个链表的头节点head和一个整数val，请你删除链表中所有满足Node.val == val的节点，并返回新的头节点 。
 * 难度：Easy
 * 思路：冗余节点
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy,p = head;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                p = p.next;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

