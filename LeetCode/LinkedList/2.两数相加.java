/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字0之外，这两个数都不会以0开头。
 * 难度：Medium
 * 思路：每个节点相加，注意进位，用一个尾节点记录最后的值方便最后处理进位，也可以用递归做
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
        ListNode head = null, tail = null;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode((l1.val+l2.val)%10);
        if (l1.val+l2.val >= 10) {
            if (l1.next == null) {
                l1.next = new ListNode(1);
            } else if (l2.next == null) {
                l2.next = new ListNode(1);
            } else {
                l1.next.val += 1;
            }
        }
        head.next = addTwoNumbers(l1.next, l2.next);
        return head;
    }
}
// @lc code=end

