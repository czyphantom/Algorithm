/**
* 题目：查找链表中倒数第k个结点
* 思路：第一个结点先往前走k步，接着第二个结点和第一个结点一起走，当第一个结点为null时第二个结点即为倒数
* 第k个结点
*/

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        int i = 1;
        while(i++ <= k) {
            if(p1 != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
