/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 * 题目：给你一个单链表的头节点head，请你判断该链表是否为回文链表。如果是，返回true；否则，返回false。
 * 难度：Easy
 * 思路：用一个数组存储一下链表值即可，如果想O(1)空间复杂度，需要改变链表结构
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
    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            values.add(p.val);
            p = p.next;
        }
        int len = values.size();
        int i=0,j=len-1;
        while (i < j) {
            if (values.get(i) != values.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
// @lc code=end

