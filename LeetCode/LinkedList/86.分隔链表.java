/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 * 题目：给你一个链表的头节点head和一个特定值x ，请你对链表进行分隔，使得所有小于x的节点都出现在大于或等于x的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 难度：Medium
 * 思路：用两个链表分别保存小于的和大于的
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
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode p = head;
        ListNode smallP = small;
        ListNode bigQ = big;
        while (p != null) {
            if (p.val < x) {
                smallP.next = p;
                smallP = p;
            } else {
                bigQ.next = p;
                bigQ = p;
            }
            p = p.next;
        }
        smallP.next = big.next;
        bigQ.next = null;
        return small.next;
    }
}
// @lc code=end

