/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 * 题目：给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 难度：Medium
 * 思路：模拟相加即可，注意进位
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
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode pre = null;
        int flag = 0;
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode();
            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)+ flag;
            if (val >= 10) {
                val = val%10;
                flag = 1;
            } else {
                flag = 0;
            }
            node.val = val;
            if (pre == null) {
                dummy.next = node;
            } else {
                pre.next = node;
            }
            pre = node;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (flag != 0) {
            ListNode last = new ListNode(1);
            pre.next = last;
        }
        return dummy.next;
    }
}
// @lc code=end

