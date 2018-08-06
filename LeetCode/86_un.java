/**
 * 题目：给定一个链表和一个特定值x，对链表进行分隔，使得所有小于x的节点都在大于或等于x的节点之前。你应当保留两个分区中每个节点的初始相对位置。
 * 难度：Medium
 * 思路：用两个节点分别构造放入小于该数的和大于该数的链表
 */

class Solution {
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