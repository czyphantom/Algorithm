/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 * 题目：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 难度：Medium
 * 思路：快慢指针
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        int i =  0;
        while (i < n+1 && fast != null) {
            fast = fast.next;
            i++;
        }
        if (i == n) {
            return head.next;
        }
        if (i < n) {
            return null;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    //更简洁的写法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for(int i = 0;i <= n ;i++) {
            if(q != null) {
                q = q.next;
            } else {
                return head.next;
            } 
        }
        while(q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}
// @lc code=end

