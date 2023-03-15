/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点head，请你删除所有重复的元素，使每个元素只出现一次 。
 * 返回同样按升序排列的结果链表。
 * 难度：Easy
 * 思路：水题
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
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            while (q != null && q.val == p.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }
}
// @lc code=end

