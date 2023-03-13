/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 * 题目：存在一个按升序排列的链表，给你这个链表的头节点head，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * 返回同样按升序排列的结果链表。
 * 难度：Medium
 * 思路：使用一个冗余节点
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy,p = head;
        while (p != null) {
            ListNode q = p.next;
            int val = p.val;
            boolean needDelete = false;
            while (q != null && q.val == val) {
                q = q.next; 
                needDelete = true;
            }
            if (needDelete) {
                pre.next = q;
                p = q;
            } else {
                pre = p;
                p = q;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

