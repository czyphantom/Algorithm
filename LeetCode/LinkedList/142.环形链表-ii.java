/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 * 题目：给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 难度：Medium
 * 思路：先找出环上的一个节点，然后计算环的长度，最后快慢指针找到第一个节点
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
    public ListNode detectCycle(ListNode head) {
        ListNode circleNode = findCircleNode(head);
        if (circleNode == null) {
            return null;
        }
        int circleLength = circleLength(circleNode);
        ListNode fast = head,slow = head;
        for (int i = 0;i < circleLength;i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private ListNode findCircleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                if (fast == slow) {
                    return fast;
                }
            }
        }
        return null;
    }

    private int circleLength(ListNode node) {
        int step = 1;
        ListNode p = node.next;
        while (p != node) {
            p = p.next;
            step++;
        }
        return step;
    }
}
// @lc code=end

