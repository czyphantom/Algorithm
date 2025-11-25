/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 * 题目：给定一个链表的头节点head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 * 难度：Medium
 * 思路：利用快慢指针可以得到环中的任意一点，并且可以求得环的长度，根据环的长度就可以得到环的起点
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

