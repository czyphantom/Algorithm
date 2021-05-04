/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字0之外，这两个数都不会以0开头。
 * 难度：Medium
 * 思路：每个节点相加，注意进位，用一个前置节点记录之前的结果。
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
        ListNode result = null;
        ListNode pre = null;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int left = 0;
        while (head1 != null && head2 != null) {
            int sum = (head1.val + head2.val + left)%10;
            left = (head1.val + head2.val + left)/10;
            ListNode node = new ListNode(sum);
            if (result == null) {
                result = node;
            }
            if (pre != null) {
                pre.next = node;
            }
            pre = node;
            head1 = head1.next;
            head2 = head2.next;
        }
        //交换顺序
        if (head2 != null) {
            ListNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        while (head1 != null) {
            int sum = (head1.val + left)%10;
            left = (head1.val + left)/10;
            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = node;
            head1 = head1.next;
        }
        if (left != 0) {
            pre.next = new ListNode(left);
        }
        return result;
    }
}
// @lc code=end

