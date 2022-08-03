/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 * 题目：给定单个链表的头head ，使用插入排序对链表进行排序，并返回排序后链表的头。
 * 难度：Medium
 * 思路：记录前面有序链表的最后一个节点
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

    //个人解法
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = head,pre = dummy;
        while (p != null) {
            ListNode q = dummy;
            while (q.next != null && q.next != p && q.next.val <= p.val) {
                q = q.next;
            }
            if (q.next == p) {
                pre = pre.next;
                p = p.next;
                continue;
            }
            ListNode r = q.next,s = p.next;
            q.next = p;
            p.next = r;
            pre.next = s;
            p = s;
        }
        return dummy.next;
    }

    //标准解法
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            pre = dummy;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}

// @lc code=end

