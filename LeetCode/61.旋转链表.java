/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 * 题目：给你一个链表的头节点head，旋转链表，将链表每个节点向右移动k个位置。
 * 难度：Medium
 * 思路：拼接链表
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
    public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0){
            return head;
        }
        int count = 1;
        ListNode p = head;
        while(p.next != null){
            count++;
            p = p.next;
        }
        k = k % count;
		ListNode pHead = head;
		ListNode q = head;
		for(int i = 0; i < count-k-1; i++){
			q = q.next;
		}
		p.next = pHead;
		pHead = q.next;
		q.next= null;
        return pHead;
    }
}
// @lc code=end

