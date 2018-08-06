/**
 * 题目：给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 难度：Easy
 * 思路：水题
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while(p != null) {
            int val = p.val;
            ListNode q = p.next;
            while(q!=null && q.val==val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }
}