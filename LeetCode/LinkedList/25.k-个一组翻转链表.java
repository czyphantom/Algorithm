/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 * 题目：给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 难度：Hard
 * 思路：先判断是否满足k个，接着递归
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k <= 1) {
            return head;
        }
        ListNode fast = head;
        for (int i = 0;i < k-1;i++) {
            if (fast == null || fast.next == null) {
                return head;
            } else {
                fast = fast.next;
            }
        }
        fast = fast.next;
        ListNode p = head,q = head.next;
        while (q != fast) {
            ListNode next = q.next;
            q.next = p;
            p = q;
            q = next;
        }
        head.next = reverseKGroup(fast, k);
        return p;
    }

    //非递归解法
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode begin;
        if (head == null || head.next == null || k == 1)
            return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        begin = dummyhead;
        int i=0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummyhead.next;
        
    }
    
    public ListNode reverse(ListNode begin, ListNode end){
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}
// @lc code=end

