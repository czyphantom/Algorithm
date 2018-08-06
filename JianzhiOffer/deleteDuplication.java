/**
* 题目：删除一个有序链表中重复的结点，重复的结点不保留
* 思路：见注释
*/

public class Solution {
    public static ListNode deleteDuplication(ListNode pHead) {
        //新建一个头结点方便删除  
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                //找到第一个不相等的结点
                while (p!= null && p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
