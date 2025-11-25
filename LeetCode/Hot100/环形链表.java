/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 * 题目：给你一个链表的头节点head ，判断链表中是否有环。
 * 难度：Easy
 * 思路：快慢指针
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && slow != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

