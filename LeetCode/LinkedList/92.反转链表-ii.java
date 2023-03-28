/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 * 题目：给你单链表的头指针head和两个整数left和right，其中left<=right。请你反转从位置left到位置right的链表节点，返回反转后的链表。
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
          if (head == null || left > right) {
            return null;
        }
        //设置一个dummyNode便于操作
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        head = dummyNode;
        //到right-left区间前面一个节点
        for (int i = 1; i < left; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        // 保存right-left区间前一个节点
        ListNode pre = head;
        // 保存right-let区间第一个节点
        ListNode fNode = head.next;
        ListNode lastNode = null;
        ListNode curNode = fNode;
        for (int i = left; i <= right; i++) {
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

