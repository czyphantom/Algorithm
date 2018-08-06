/**
 * 题目：给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 难度：Medium
 * 思路：递归
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode head = new ListNode(1);
        head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }

    public int getLength(ListNode l) {
        int count = 0;
        while (l != null) {
            l = l.next;
            count++;
        }
        return count;
    }

    public ListNode helper(ListNode l1, ListNode l2, int offset) {
        if (l1 == null) {
            return null;
        }
        ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
        ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
        if (post != null && post.val > 9) {
            result.val += 1;
            post.val = post.val % 10;
        }
        result.next = post;
        return result;
    }
}