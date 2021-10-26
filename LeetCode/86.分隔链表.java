/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 * 题目：给你一个链表的头节点head和一个特定值x ，请你对链表进行分隔，使得所有小于x的节点都出现在大于或等于x的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 难度：Medium
 * 思路：用两个链表分别保存小于的和大于的
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
    public ListNode partition(ListNode head, int x) {
        ListNode small = null, greater = null,p = head, sHead = head, gHead = null;
        while (p != null) {
            if (p.val < x) {
                if (small == null) {
                    small = p;
                    sHead = small;
                } else {
                    small.next = p;
                    small = p;
                }
            } else {
                if (greater == null) {
                    greater = p;
                    gHead = greater;
                } else {
                    greater.next = p;
                    greater = p;
                }
            }
             p = p.next;
        }
        if (small != null) {
            small.next = gHead;
        }
        if (greater != null) {
            greater.next = null;
        }  
        return sHead;
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0); 
        ListNode curr1 = dummy1, curr2 = dummy2;
        while (head != null){
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            } else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}
// @lc code=end

