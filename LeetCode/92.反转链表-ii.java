/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 * 题目：给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 难度：Medium
 * 思路：用冗余节点保存即可
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
          if (head == null || m > n) {
            return null;
        }
        //设置一个dummyNode便于操作
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        //到m-n区间前面一个节点
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        // 保存n-m区间前一个节点
        ListNode pre = head;
        // 保存n-m区间第一个节点
        ListNode fNode = head.next;
        ListNode lastNode = null;
        ListNode curNode = fNode;
        for (int i = m; i <= n; i++) {
            ListNode tmp = curNode.next;
            curNode.next = lastNode;
            lastNode = curNode;
            curNode = tmp;
        }
        pre.next = lastNode;
        fNode.next = curNode;
        return dummyNode.next;
    }
}
// @lc code=end

