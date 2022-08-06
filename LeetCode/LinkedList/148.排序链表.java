/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 * 题目：给你链表的头结点head ，请将其按升序排列并返回排序后的链表 。
 * 难度：Medium
 * 思路：归并排序或者快速排序
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
    //归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head,fast = head,pre = null;
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (pre != null) {
            pre.next = null;
        }
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left, right);
    }

    private ListNode merge(ListNode p, ListNode q) {
        if (p == null) {
            return q;
        }
        if (q == null) {
            return p;
        }
        if (p.val < q.val) {
            p.next = merge(p.next, q);
        } else {
            q.next = merge(p, q.next);
        }
        return p.val < q.val ? p : q;
    }

    //快速排序
    public ListNode sortList2(ListNode head) {
        quickSort(head,null);
        return head;
    }

    private void quickSort(ListNode head, ListNode end) {
        if(head != end && head.next != end){
            ListNode q = partition(head, end);
            quickSort(head,q);
            quickSort(q.next,end);
        }
    }
    private ListNode partition(ListNode head, ListNode end){
        ListNode p = head;
        ListNode cur = head.next;
        int key = head.val;
        while(cur != end){
            if(cur.val <= key){
                p = p.next;
                int tmp = p.val;
                p.val = cur.val;
                cur.val = tmp;
            }
            cur = cur.next;
        }
        int tmp = head.val;
        head.val = p.val;
        p.val = tmp;
        return p;
    }
}
// @lc code=end

