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
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2. val) {
            l2.next = merge(l1.next, l2);
        } else {
            l1.next = merge(l1, l2.next);
        }
        return l1.val < l2.val ? l1 : l2;
    }

    //快速排序
    public ListNode sortList(ListNode head) {
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

