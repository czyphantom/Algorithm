/**
* 题目：找两个链表的公共结点
* 思路：先计算两个链表的差值，然后让长的先走，然后当剩下的长度相同时一起走，直到走到头或者相同结点
*/

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        int len1 = 0;
        int len2 = 0;
        while(p1 != null) {
            ++len1;
            p1 = p1.next;
        }
        while(p2 != null) {
            ++len2;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(len1 < len2) {
            ListNode tmp = p1;
            p1 = p2;
            p2 = tmp;
        }
        for(int i = 0;i < len1-len2;i++) {
            p1 = p1.next;
        }
        while(p1 != null) {
            if(p1 == p2)
                break;
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
