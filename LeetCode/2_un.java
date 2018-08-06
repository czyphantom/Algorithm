/**
 * 题目：给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。你可以假设除了数字0之外，这两个数字都不会以零开头。
 * 难度：Medium
 * 思路：水题
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
            return null;
        int first = (l1.val+l2.val)%10;
        int flag = (l1.val+l2.val)/10;
        ListNode head = new ListNode(first);
        ListNode p = head;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null && l2 != null) {
            int val = (l1.val+l2.val+flag)%10;
            flag = (l1.val+l2.val+flag)/10;
            ListNode temp = new ListNode(val);
            p.next = temp;
            p = temp;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int val = (l1.val+flag)%10;
            flag = (l1.val+flag)/10;
            ListNode temp = new ListNode(val);
            p.next = temp;
            p = temp;
            l1 = l1.next;
        }
        while(l2 != null) {
            int val = (l2.val+flag)%10;
            flag = (l2.val+flag)/10;
            ListNode temp = new ListNode(val);
            p.next = temp;
            p = temp;
            l2 = l2.next;
        }
        if(flag != 0) {
            ListNode last = new ListNode(1);
            p.next = last;
        }
        return head;
    }
}