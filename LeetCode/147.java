/**
 * 题目：对链表进行插入排序。
 * 难度：Medium
 * 思路：使用冗余节点
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode current = head;
        while (current != null) {
            pre = helper;
            while (pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            ListNode next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = next;
        }
        return helper.next;
    }
}