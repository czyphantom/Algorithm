/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 * 题目：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 难度：Medium
 * 思路：递归
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next.next;
        ListNode result = head.next;
        head.next.next = head;
        head.next = swapPairs(next);
        return result;
    }

    //非递归解法
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next.next;
            pre.next.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        return dummy.next;
    }
}
// @lc code=end

