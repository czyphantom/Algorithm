/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 * 题目：请编写一个函数，用于删除单链表中某个特定节点。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问要被删除的节点。
 * 题目数据保证需要删除的节点不是末尾节点。
 * 难度：Easy
 * 思路：略
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode p = node;
        while (p != null && p.next != null) {
            p.val = p.next.val;
            if (p.next.next == null) {
                p.next = null;
            }
            p = p.next;
        }
    }
}
// @lc code=end

