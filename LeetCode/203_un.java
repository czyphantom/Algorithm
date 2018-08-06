/**
 * 题目：删除链表中等于给定值val的所有节点。
 * 难度：Easy
 * 思路：水题，注意一些细节即可。
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
        while(head!=null && head.val==val)
            head = head.next;
        ListNode p = null;
        if(head != null)
            p = head.next;
        ListNode pre = head;
        while(p != null) {
            if(p.val == val) {
                pre.next = p.next;
                p = p.next;
            } else {
                pre = pre.next;
                p = p.next;
            }
        }

        return head;
    }
}