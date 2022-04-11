/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 * 题目：给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 难度：Medium
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
    public ListNode detectCycle(ListNode head) {
        //找一个环上的节点
        ListNode circleNode = findCircle(head);
        if (circleNode != null) {
            //先算出环的长度
            ListNode slow = circleNode;
            ListNode fast = circleNode;
            int circleLen  = 0;
            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
                circleLen++;
                if (fast != null) {
                    fast = fast.next;
                    if (fast == slow) {
                        break;
                    }
                }
            }

            //快慢指针找出首节点
            slow = head;
            fast = head;
            for (int i = 0;i < circleLen;i++) {
                fast = fast.next;
            }
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }

    private ListNode findCircle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                if (fast == slow) {
                    return slow;
                }
            }
        }
        return null;
    }
}
// @lc code=end

